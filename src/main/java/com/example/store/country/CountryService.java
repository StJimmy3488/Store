package com.example.store.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country getCountryById(Long countryId){
        return countryRepository.getById(countryId);
    }

    public void deleteCountryById(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    public Country saveOrUpdateCountry(Country country){
        return countryRepository.save(country);
    }
}
