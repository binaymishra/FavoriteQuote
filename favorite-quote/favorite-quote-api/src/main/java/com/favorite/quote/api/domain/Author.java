package com.favorite.quote.api.domain;

import org.apache.commons.lang3.StringUtils;

public class Author {
	
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	//Other methods
	public String getFullName(){
		StringBuilder fullName = new StringBuilder();
		if(StringUtils.isNotEmpty(firstName)){
			fullName.append(firstName);
			if(StringUtils.isNotEmpty(middleName)){
				fullName.append(" ");
				fullName.append(middleName);
			}
			fullName.append(" ");
			fullName.append(StringUtils.defaultIfEmpty(lastName, ""));
		}
		return fullName.toString().trim();
	}
	

}
