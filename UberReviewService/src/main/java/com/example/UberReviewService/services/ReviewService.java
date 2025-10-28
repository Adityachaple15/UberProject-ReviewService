package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Reviews;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService (ReviewRepository reviewRepository) {
        this.reviewRepository=reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*********");
        Reviews r = Reviews.builder()
                .content("quality is good")
                .rating(5.0).build();
        System.out.println(r);
        reviewRepository.save(r);
        System.out.println(r.getId());

        List<Reviews> reviews = reviewRepository.findAll();

        for (Reviews reviews1:reviews){
            System.out.println(r.getContent());
        }
       // reviewRepository.deleteById(2);
    }
}
