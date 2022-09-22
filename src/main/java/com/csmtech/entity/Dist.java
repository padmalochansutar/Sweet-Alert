package com.csmtech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dist {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer distId;
	
	private String distName;

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	@Override
	public String toString() {
		return "Block [distId=" + distId + ", distName=" + distName + "]";
	}
}
