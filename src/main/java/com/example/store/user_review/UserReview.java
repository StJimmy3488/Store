package com.example.store.user_review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_review")
@Entity
public class UserReview {

    private enum UserRating {A, AA, AAA, AAAA, AAAAA;}

    @Id
    @Column(name = "user_review_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserReviewId;

    @Column(name = "user_review", nullable = false)
    private String UserReview;

    @Column(name = "user_rating")
    @Enumerated(EnumType.ORDINAL)
    private UserRating userRating;

    @Column(name = "user_review_created_at", nullable = false)
    private LocalDate UserReviewCreatedAt;


}