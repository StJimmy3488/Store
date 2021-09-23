package com.example.store.user;

import com.example.store.cart.Cart;
import com.example.store.payment.Payment;
import com.example.store.user_address.UserAddress;
import com.example.store.user_review.UserReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
@Entity
public class User {

    private enum UserGender {FEMALE, MALE}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, unique = true)
    private long userId;

    @Column(name = "user_first_name", nullable = false)
    private String UserFirstName;

    @Column(name = "user_last_name", nullable = false)
    private String UserLastName;

    @Column(name = "user_username", nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_user_role", nullable = false)
    private String userRole;

    @Column(name = "user_last_login")
    private LocalDate UserLastLogin;

    @Column(name = "user_dob", nullable = false)
    private LocalDate UserDateOfBirth;

    @Transient
    private Integer UserAge;

    @Email
    @Column(name = "user_email", nullable = false, unique = true)
    private String UserEmail;

    @Column(name = "user_phone", nullable = false)
    private String UserPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private UserGender UserGender;

    @Column(name = "user_created_at", nullable = false)
    private LocalDate UserCreatedAt;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserReview> userReviews = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Payment> payments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserAddress> userAddresses = new ArrayList<>();


    public Integer UserGetAge() {
        return Period.between(UserDateOfBirth, LocalDate.now()).getYears();
    }


}
