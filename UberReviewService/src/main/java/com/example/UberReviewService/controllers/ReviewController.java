package com.example.UberReviewService.controllers;

import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dto.CreateReviewDto;
import com.example.UberReviewService.dto.ReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    public ReviewController(ReviewService reviewService,CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }


    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto request){
        Review incomimgReview = this.createReviewDtoToReviewAdapter.convertDto(request);
        if(incomimgReview == null){
            return new ResponseEntity<>("Invalid arguments",HttpStatus.BAD_REQUEST);
        }
        Review review = this.reviewService.publishReview(incomimgReview);
        ReviewDto response = ReviewDto.builder()
                .id(review.getId())
                .rating(review.getRating())
                .booking(review.getBooking().getId())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId){
        try{
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId){
        try{
            boolean isDeleted = this.reviewService.deleteReviewById(reviewId);
            if(!isDeleted)return new ResponseEntity<>("Unable to delete review",HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId,@RequestBody Review request){
        try{
            Review review = this.reviewService.updateReview(reviewId,request);
            return new ResponseEntity<>(review,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

