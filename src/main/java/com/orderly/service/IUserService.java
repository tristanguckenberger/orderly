package com.orderly.service;

import com.orderly.dto.User;

public interface IUserService {
	void createUser(String email, String name, String password);
}
