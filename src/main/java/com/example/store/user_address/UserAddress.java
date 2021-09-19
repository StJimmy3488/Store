package com.example.store.user_address;

import com.example.store.country.Country;
import com.example.store.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_address_id", nullable = false)
    private long addressId;

    @Column(name = "user_address_line_1", nullable = false)
    private String addressLine1;

    @Column(name = "user_address_line_2")
    private String addressLine2;

    @Column(name = "user_address_city", nullable = false)
    private String city;

    @Column(name = "user_address_region", nullable = false)
    private String region;

    @Column(name = "user_address__zip_code", nullable = false)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

}