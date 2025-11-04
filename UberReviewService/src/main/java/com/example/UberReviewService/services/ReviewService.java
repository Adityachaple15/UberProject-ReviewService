package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Reviews;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private  final BookingRepository bookingRepository;

    public ReviewService (ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository=reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("*********");
//        Reviews r = Reviews.builder()
//                .content("quality is good")
//                .rating(5.0).build();
//
//        Booking b = Booking.builder()
//                        .endTime(new Date())
//                        .reviews(r)
//                        .build();
//
////        reviewRepository.save(r);
//
//        bookingRepository.save(b);
//
//        System.out.println(r);
//        System.out.println(r.getId());
//
//        List<Reviews> reviews = reviewRepository.findAll();
//
//        for (Reviews reviews1:reviews){
//            System.out.println(r.getContent());
//        }

        Optional<Booking> b = bookingRepository.findById(2l);
        if(b.isPresent()){
            bookingRepository.delete(b.get());
        }
       // reviewRepository.deleteById(2);
    }
}
