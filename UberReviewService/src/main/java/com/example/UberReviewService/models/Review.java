package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "booking_review")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private double rating;

}
