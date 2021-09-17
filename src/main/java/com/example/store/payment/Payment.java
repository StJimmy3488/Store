package com.example.store.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", nullable = false)
    private long paymentId;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "account_no", nullable = false)
    private String accountNo;

    @Column(name = "expiry", nullable = false)
    private LocalDate expiry;
}
