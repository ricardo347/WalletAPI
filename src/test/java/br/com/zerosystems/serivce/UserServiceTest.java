package br.com.zerosystems.serivce;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.zerosystems.entity.User;
import br.com.zerosystems.repository.UserRepository;
import br.com.zerosystems.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
	@MockBean
	UserRepository repository;
	
	@Autowired
	UserService service;
	
	@Before
	public void setup() {
		//mockando o userrepository passando uma string aleatoria
		//e retornara um User
		BDDMockito.given(repository.
				findByEmailEquals(Mockito.anyString())).
		willReturn(Optional.of(new User()));
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> user = service.findByEmail("email@teste.com");		
		assertTrue(user.isPresent());
	}
}
