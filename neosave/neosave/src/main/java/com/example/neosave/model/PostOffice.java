package com.example.neosave.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class PostOffice {
	
	@JsonProperty("Name")
	String name;
	
	@JsonProperty("Description")
	String description;
	
	@JsonProperty("BranchType")
	String branchType;
	
	@JsonProperty("DeliveryStatus")
	String deliveryStatus;
	
	@JsonProperty("Circle")
	String circle;
	
	@JsonProperty("District")
	String district;
	
	@JsonProperty("Division")
	String division;
	
	@JsonProperty("Region")
	String region;
	
	@JsonProperty("State")
	String state;
	
	@JsonProperty("Country")
	String country;
	
	@JsonProperty("Block")
	String block;
	
	@JsonProperty("Pincode")
	String pincode;
	
	

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	

}
