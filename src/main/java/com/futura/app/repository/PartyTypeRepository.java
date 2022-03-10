package com.futura.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.PartyType;

@Repository
public interface PartyTypeRepository extends JpaRepository<PartyType, Long>
{

	PartyType findByPartyTypeDesc(String partyTypeDesc);
		




}
