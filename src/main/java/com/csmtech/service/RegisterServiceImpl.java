package com.csmtech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Cable;
import com.csmtech.entity.Register;
import com.csmtech.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public List<Object[]> fetchData(Long number, String email) {
		return registerRepository.getByNumberAndEmail(number,email);
	}

	@Override
	public String saveData(Register register) {
	    Register save = registerRepository.save(register);
		String resp=save.toString();
		System.out.println("the resp is:"+resp);
		return resp;
	}

	@Override
	public List<Register> findData() {
		// TODO Auto-generated method stub
		return registerRepository.findAll();
	}

	@Override
	public List<Register> findData(Integer cId) {
		return registerRepository.findByCableId(cId);
		
	}

	@Override
	public List<Register> findDistId(Integer dId) {
		
		return registerRepository.findBydistId(dId);
	}

}
