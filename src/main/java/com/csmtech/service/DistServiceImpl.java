package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Dist;
import com.csmtech.repository.DistRepository;

@Service
public class DistServiceImpl implements DistService {
	@Autowired
	private DistRepository distRepository;

	@Override
	public List<Dist> findData() {
		
		return distRepository.findAll();
	}

}
