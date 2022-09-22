package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csmtech.entity.Cable;
import com.csmtech.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
    @Query("Select r.emailId,r.mobileNo from Register r where mobileNo=:number or emailId=:email ")
	List<Object[]> getByNumberAndEmail(Long number, String email);
	@Query("from Register where cableId=:cId")
	List<Register> findByCableId(Integer cId);
	@Query("from Register where distId=:dId")
	List<Register> findBydistId(Integer dId);

//     @Query("from register where cableId=:cId")
//	List<Register> findByCableId(Cable cId);

}
