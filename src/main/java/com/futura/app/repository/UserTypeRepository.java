package com.futura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

	UserType findByUserTypeDesc(String userTypeDesc);
		



}
