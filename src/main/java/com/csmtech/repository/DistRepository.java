package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.entity.Dist;
@Repository
public interface DistRepository extends JpaRepository<Dist, Integer> {

}
