package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.entity.Block;
@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {

	List<Block> findByDistId(Integer id);

}
