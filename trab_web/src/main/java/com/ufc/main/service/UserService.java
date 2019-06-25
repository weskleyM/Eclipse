package com.ufc.main.service;

import com.ufc.main.model.User;

public interface UserService {

	public void saveUser(User user);

	public boolean userJaExiste(User user);
}
