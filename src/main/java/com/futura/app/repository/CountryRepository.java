package com.futura.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	//Country findByUserTypeDesc(String countryFullName);

	Country findBycountryFullName(String countryFullName);
		



}
