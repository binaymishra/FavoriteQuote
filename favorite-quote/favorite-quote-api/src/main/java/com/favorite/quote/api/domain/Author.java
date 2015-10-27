package com.favorite.quote.api.domain;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Author implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Author() {	}
	
	
	
	public Author(Long id) {
		super();
		this.id = id;
	}

	

	public Author(Long id, String firstName, String middleName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}



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
		this.firstName = StringUtils.defaultString(firstName, "");
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = StringUtils.defaultString(middleName, "");
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = StringUtils.defaultString(lastName, "");
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
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		builder.append("id", this.id);
		builder.append("firstName", this.firstName);
		builder.append("middleName", this.middleName);
		builder.append("lastName", this.lastName);
		builder.append("fullName", this.getFullName());
		return builder.toString();
	}
}
