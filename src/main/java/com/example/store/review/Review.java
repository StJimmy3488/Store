package com.example.store.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


enum Rating { A, AA, AAA, AAAA, AAAAA; }

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    @Column(name = "review")
    private String review;

    @Column(columnDefinition = "ENUM('A', 'AA', 'AAA', 'AAAA', 'AAAAA')", name = "rating", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

}