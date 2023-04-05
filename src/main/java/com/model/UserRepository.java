package com.model;

import java.util.HashMap;
import java.util.Map;

import com.exception.UserAlreadyExistForGivenId;
import com.exception.UserDoesNotExist;

public class UserRepository {

	public static Map<String, User> users = new HashMap<>();

	public User addUser(User user) throws UserAlreadyExistForGivenId {

		if (this.users.containsKey(user.id))
			throw new UserAlreadyExistForGivenId();

		this.users.put(user.id, user);

		return user;
	}

	public User getUser(String id) throws UserDoesNotExist {
		if (!users.containsKey(id))
			throw new UserDoesNotExist();

		return users.get(id);
	}

}
