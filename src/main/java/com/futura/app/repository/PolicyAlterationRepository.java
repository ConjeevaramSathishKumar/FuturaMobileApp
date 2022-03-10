package com.futura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.PolicyAlteration;

@Repository
public interface PolicyAlterationRepository extends JpaRepository<PolicyAlteration, Long> {

	PolicyAlteration findByAlterationName(String alterationName);

}
