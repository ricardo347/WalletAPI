package br.com.zerosystems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@ActiveProfiles("test")
public class HelloWorld {

	@Test
	public void testHelloWorld() {
		assertEquals(1, 1);
	}
}
