package com.example.store.user;

import com.example.store.cart_item.CartItem;
import com.example.store.payment.Payment;
import com.example.store.role.Role;
import com.example.store.user_address.UserAddress;
import com.example.store.user_review.UserReview;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, unique = true)
    private long userId;

    @Column(name = "user_username", nullable = false, unique = true)
    private String userName;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_first_name", nullable = false)
    private String userFirstName;

    @Column(name = "user_last_name", nullable = false)
    private String userLastName;

    @Column(name = "user_dob")
    private LocalDate userDateOfBirth;

    @Transient
    private Integer userAge;

    @Column(name = "user_phone")
    private String userPhoneNumber;

    @Email
    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_created_at", nullable = false)
    private LocalDate userCreatedAt;

    @Column(name = "user_last_login")
    private LocalDate userLastLogin;

    @Column(name = "enabled")
    private Boolean enabled;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<UserReview> userReviews = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Payment> payments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<CartItem> cart = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<UserAddress> userAddresses = new ArrayList<>();

    @Transient
    private String userRole;


    public Integer userGetAge() {
        return Period.between(userDateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
