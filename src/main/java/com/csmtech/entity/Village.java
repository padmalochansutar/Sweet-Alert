package com.csmtech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Village {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer villageId;
	
	private String villageName;
	@JoinColumn(name="blockId")
	private Integer blockId;

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	@Override
	public String toString() {
		return "Village [villageId=" + villageId + ", villageName=" + villageName + ", blockId=" + blockId + "]";
	}
	
	

}
