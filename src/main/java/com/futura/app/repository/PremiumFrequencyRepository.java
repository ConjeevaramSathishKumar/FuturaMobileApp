package com.futura.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.PremiumFrequency;

@Repository
public interface PremiumFrequencyRepository extends JpaRepository<PremiumFrequency, Long>
{

	PremiumFrequency findByFrequencyTerm(String frequencyTerm);
		



}
