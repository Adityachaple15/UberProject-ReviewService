package com.example.UberReviewService.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Builder
@Entity
        @Table(name = "bookingreview")
@AllArgsConstructor
@NoArgsConstructor
public class Reviews extends BaseModel {

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private double rating;


}
