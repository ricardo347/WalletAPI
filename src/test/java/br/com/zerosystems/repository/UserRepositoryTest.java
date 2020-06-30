package br.com.zerosystems.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.zerosystems.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@Before
	public void setup() {
		User u = new User();
		u.setName("Setup User");
		u.setPassword("senha123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("teste");
		u.setPassword("pass");
		u.setEmail("email@uol.com.br");		
		
		User response = repository.save(u);		
		assertNotNull(response);
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);;
	}
}
