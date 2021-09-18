package com.example.store.user_review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


enum UserRating { A, AA, AAA, AAAA, AAAAA; }

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_review")
@Entity
public class UserReview {

    @Id
    @Column(name = "user_review_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserReviewId;

    @Column(name = "user_review")
    private String UserReview;

    @Column(columnDefinition = "ENUM('A', 'AA', 'AAA', 'AAAA', 'AAAAA')", name = "user_rating", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserRating userRating;

    @Column(name = "user_review_created_at", nullable = false)
    private LocalDate UserReviewCreatedAt;

//    @Column(name = "user_review_product_id", nullable = false)
//    private Long productId;
//
//    @Column(name = "user_review_user_id", nullable = false)
//    private Long userId;

}