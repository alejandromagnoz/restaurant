package com.transbank;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(RestaurantBackendApplication.class)
public class RestaurantBackendApplicationTests {

	@Test
	public void main() throws ParseException {
		RestaurantBackendApplication.main(new String[0]);
	}

}
