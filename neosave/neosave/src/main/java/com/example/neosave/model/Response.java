package com.example.neosave.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Response {
	
	@JsonProperty("Message")
	String message;
	
	@JsonProperty("Status") 
	String status;
	
	 @JsonProperty("PostOffice")
	List<PostOffice> postOffice;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PostOffice> getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(List<PostOffice> postOffice) {
		this.postOffice = postOffice;
	}

	
	
}
