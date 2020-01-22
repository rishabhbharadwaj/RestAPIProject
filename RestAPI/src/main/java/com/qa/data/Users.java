package com.qa.data;

// POJO - plane old java object equivalent to JSON
public class Users {

	public String name;
	public String job;
	
	public Users() {		
		
	}
	
	public Users(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
