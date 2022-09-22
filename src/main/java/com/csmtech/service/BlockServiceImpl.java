package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Block;
import com.csmtech.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {
	@Autowired
	private BlockRepository blockRepository;

	@Override
	public List<Block> fetchData(Integer id) {
		
		return blockRepository.findByDistId(id);
	}
	

    
}
