package com.csmtech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blockId;
	
	private String blockName;
	@JoinColumn(name="distId")
	private Integer distId;

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}

	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", blockName=" + blockName + ", distId=" + distId + "]";
	}
	
	
	

}
