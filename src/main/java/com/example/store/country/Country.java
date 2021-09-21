package com.example.store.country;

import com.example.store.user_address.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id", nullable = false, unique = true)
    private Long countryId;

    @Column(name = "name", nullable = false)
    private String countryName;

    @Column(name = "country_isd_code", nullable = false)
    private String countryISDCode;

    @OneToMany(mappedBy = "country")
    private List<UserAddress> userAddresses = new ArrayList<>();


}