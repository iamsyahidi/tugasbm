package com.iam.tugasbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iam.tugasbm.model.entity.DetailBiodata;

@Repository
public interface DetailRepository extends JpaRepository<DetailBiodata, Integer> {
	List<DetailBiodata>
	findAllByNmDati2(String nmDati2);
}
