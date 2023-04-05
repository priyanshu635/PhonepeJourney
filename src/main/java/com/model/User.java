package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	String id;
	String name;
	UserState userState;

	public User(String id, String name, UserState userState) {
		super();
		this.id = id;
		this.name = name;
		this.userState = userState;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userState=" + userState
				+ "]";
	}
}
