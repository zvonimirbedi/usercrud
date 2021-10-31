package com.example.usercrud;

import com.example.usercrud.dto.UserDto;
import com.example.usercrud.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsercrudApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	int randomServerPort;

	private String createURLWithPort(String uri) {
		return "http://localhost:" + randomServerPort + uri;
	}

	@Test
	@Order(1)
	public void createUserWithDescription(){
		UserDto newUser = new UserDto(
				"username",
				"firstname",
				"lastname",
				23,
				"description for somthn");
		ResponseEntity<UserDto> response = restTemplate.withBasicAuth("user1","user1pass")
				.postForEntity(createURLWithPort("/users"), newUser, UserDto.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		UserDto user = response.getBody();
		assertThat(newUser, equalTo(user));
	}


	@Test
	@Order(2)
	public void createUserWithoutDescription(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UserDto newUser = new UserDto(
				"username",
				"firstname",
				"lastname",
				23,
				null);
		ResponseEntity<UserDto> response = restTemplate.withBasicAuth("user1","user1pass")
				.postForEntity(createURLWithPort("/users"), newUser, UserDto.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		UserDto user = response.getBody();
		assertThat(newUser, equalTo(user));
	}

	@Test
	@Order(3)
	public void updateUser(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		User newUser = new User(
				5,
				"username",
				"firstname",
				"lastname",
				33,
				"description asdf");
		ResponseEntity<User> response = restTemplate.withBasicAuth("user1","user1pass")
				.exchange(createURLWithPort("/users"), HttpMethod.PUT,  new HttpEntity<>(newUser) , User.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		User user = response.getBody();
		assertThat(newUser, equalTo(user));
	}

	@Test
	@Order(4)
	public void deleteUser(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> response = restTemplate.withBasicAuth("user1","user1pass")
				.exchange(createURLWithPort("/users/" + 5), HttpMethod.DELETE,  null , String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		assertThat(response.getStatusCode().value(), equalTo(200));
	}

	@Test
	@Order(5)
	public void getAllUser(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<User[]> response = restTemplate.withBasicAuth("user1","user1pass")
				.getForEntity(createURLWithPort("/users"), User[].class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		assertThat(response.getBody().length , equalTo(4));
	}


	@Test
	@Order(6)
	public void mixTest(){
		UserDto newDtoUser = new UserDto(
				"username",
				"firstname",
				"lastname",
				23,
				"description for somthn");
		ResponseEntity<UserDto> response = restTemplate.withBasicAuth("user1","user1pass")
				.postForEntity(createURLWithPort("/users"), newDtoUser, UserDto.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		UserDto userDto = response.getBody();
		assertThat(newDtoUser, equalTo(userDto));


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		User newUser = new User(
				1,
				"Grunf",
				"Alan",
				"Ford",
				34,
				"description asdf");
		ResponseEntity<User> responseUpdate = restTemplate.withBasicAuth("user1","user1pass")
				.exchange(createURLWithPort("/users"), HttpMethod.PUT,  new HttpEntity<>(newUser) , User.class);
		System.out.println(responseUpdate.getStatusCode());
		System.out.println(responseUpdate.getBody());
		User user = responseUpdate.getBody();
		assertThat(newUser, equalTo(user));

		ResponseEntity<String> responseDelete = restTemplate.withBasicAuth("user1","user1pass")
				.exchange(createURLWithPort("/users/" + 2), HttpMethod.DELETE,  null , String.class);
		System.out.println(responseDelete.getStatusCode());
		System.out.println(responseDelete.getBody());
		assertThat(responseDelete.getStatusCode().value(), equalTo(200));


		ResponseEntity<User[]> responseGetAll = restTemplate.withBasicAuth("user1","user1pass")
				.getForEntity(createURLWithPort("/users"), User[].class);
		System.out.println(responseGetAll.getStatusCode());
		System.out.println(responseGetAll.getBody());
		assertThat(responseGetAll.getBody().length , equalTo(4));

	}


}
