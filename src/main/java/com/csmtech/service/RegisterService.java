package com.csmtech.service;

import java.util.List;
import java.util.Optional;

import com.csmtech.entity.Cable;
import com.csmtech.entity.Register;

public interface RegisterService {

	List<Object[]> fetchData(Long number, String email);

	String saveData(Register register);

	List<Register> findData();

	

	List<Register> findData(Integer cId);

	List<Register> findDistId(Integer dId);

}
