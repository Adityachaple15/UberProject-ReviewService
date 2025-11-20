package com.example.UberReviewService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Data
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
    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking; // we have defined a 1:1 relationship between booking and review


}
