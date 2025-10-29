package com.example.UberReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Reviews{
    @Column(nullable = false)
    private String PassengerReviewContent;
    @Column(nullable = false)
    private String PassengerRating;
}
