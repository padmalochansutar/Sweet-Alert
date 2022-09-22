package com.csmtech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cableId;
	
	private String cableName;
	
	private Integer totalCable;
	
	private Long cablePrice;

	public Integer getCableId() {
		return cableId;
	}

	public void setCableId(Integer cableId) {
		this.cableId = cableId;
	}

	public String getCableName() {
		return cableName;
	}

	public void setCableName(String cableName) {
		this.cableName = cableName;
	}

	public Integer getTotalCable() {
		return totalCable;
	}

	public void setTotalCable(Integer totalCable) {
		this.totalCable = totalCable;
	}

	public Long getCablePrice() {
		return cablePrice;
	}

	public void setCablePrice(Long cablePrice) {
		this.cablePrice = cablePrice;
	}

	@Override
	public String toString() {
		return "Cable [cableId=" + cableId + ", cableName=" + cableName + ", totalCable=" + totalCable + ", cablePrice="
				+ cablePrice + "]";
	}
	
	

}
