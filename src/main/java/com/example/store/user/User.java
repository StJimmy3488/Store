package com.example.store.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;

enum UserGender {FEMALE, MALE}

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

    @Column(name = "user_first_name")
    private String UserFirstName;

    @Column(name = "user_last_name")
    private String UserLastName;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_user_role")
    private String userRole;

    @Column(name = "user_last_login")
    private LocalDate UserLastLogin;

    @Column(name = "user_dob")
    private LocalDate UserDateOfBirth;

    @Transient
    private Integer UserAge;

    @Email
    @Column(name = "user_email")
    private String UserEmail;

    @Column(name = "user_phone")
    private String UserPhoneNumber;

    @Column(columnDefinition = "ENUM ('FEMALE, MALE')", name = "user_gender")
    private UserGender UserGender;

    @Column(name = "user_created_at")
    private LocalDate UserCreatedAt;

    public Integer UserGetAge () {
        return Period.between(UserDateOfBirth, LocalDate.now()).getYears();
    }



}
