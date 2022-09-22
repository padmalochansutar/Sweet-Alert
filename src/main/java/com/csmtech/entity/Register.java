package com.csmtech.entity;

import java.io.File;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.qos.logback.core.subst.Token.Type;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rId;
	
	private String rName;
	
	private  Long mobileNo;
	
	private String emailId;
	
	private String gender;
	
	private Date date;
	
	private String pic;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="distId")
	private Dist dist;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="blockId")
	private Block block;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="villageId")
	private Village village;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="cableId")
	private Cable cable;
	
	private String address;
	
	private Long pincode;

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Dist getDist() {
		return dist;
	}

	public void setDist(Dist dist) {
		this.dist = dist;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Cable getCable() {
		return cable;
	}

	public void setCable(Cable cable) {
		this.cable = cable;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Register [rId=" + rId + ", rName=" + rName + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", gender=" + gender + ", date=" + date + ", pic=" + pic + ", dist=" + dist + ", block=" + block
				+ ", village=" + village + ", cable=" + cable + ", address=" + address + ", pincode=" + pincode + "]";
	}

	
	
}
