package br.com.zerosystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zerosystems.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmailEquals(String email);		
	
}
