package com.futura.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.PartyIdentificationType;

@Repository
public interface PartyIdentificationTypeRepository extends JpaRepository<PartyIdentificationType, Long> {

	PartyIdentificationType findByPartyIdType(String partyIdentificationType);

	
 

}
