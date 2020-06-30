package br.com.zerosystems.service;

import java.util.Optional;

import br.com.zerosystems.entity.User;

public interface UserService {

	public User save(User user);
	public Optional<User> findByEmail(String email);
}
