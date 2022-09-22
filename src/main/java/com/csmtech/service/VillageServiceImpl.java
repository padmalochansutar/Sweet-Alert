package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Village;
import com.csmtech.repository.VillageRepository;

@Service
public class VillageServiceImpl implements VillageService {
	@Autowired
	private VillageRepository villageRepository;

	@Override
	public List<Village> fetchData(Integer id) {
		
		return villageRepository.findByBlockId(id) ;
	}

}
