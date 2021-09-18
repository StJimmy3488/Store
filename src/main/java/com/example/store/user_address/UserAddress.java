package com.example.store.user_address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// komentārs
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_address_id")
    private long addressId;

    @Column(name = "user_address_line_1")
    private String addressLine1;

    @Column(name = "user_address_line_2")
    private String addressLine2;

    @Column(name = "user_address_city")
    private String city;

    @Column(name = "user_address_region")
    private String region;

    @Column(name = "user_address__zip_code")
    private String zipCode;

}