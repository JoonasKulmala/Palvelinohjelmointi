package com.example.Palvelinohjelmointi.domain;

import javax.validation.constraints.Size;

public class Friend {
	
	@Size(min=2, max=30)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Friend [name=" + name +	 "]";
	}


}
