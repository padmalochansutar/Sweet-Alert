package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.entity.Cable;
@Repository
public interface CableRepository extends JpaRepository<Cable, Integer> {

}
