package com.iam.tugasbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iam.tugasbm.model.entity.Biodata;

@Repository

public interface BiodataRepository extends JpaRepository<Biodata, Integer>{
	
}
