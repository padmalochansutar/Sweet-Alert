package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Cable;
import com.csmtech.repository.CableRepository;

@Service
public class CableServiceImpl implements CableService {
	@Autowired
    private CableRepository cableRepository;
	@Override
	public List<Cable> findData() {
	
		return cableRepository.findAll();
	}

}
