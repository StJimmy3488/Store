package com.example.store.product_category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;

enum Gender {FEMALE, MALE}

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(columnDefinition = "ENUM ('FEMALE, MALE')", name = "gender")
    private Gender gender;

    @Column(name = "created_at")
    private LocalDate createdAt;

    public Integer getAge () {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }



}
