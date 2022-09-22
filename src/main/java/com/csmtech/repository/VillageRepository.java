package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.entity.Village;
@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {

	List<Village> findByBlockId(Integer id);
	

}
