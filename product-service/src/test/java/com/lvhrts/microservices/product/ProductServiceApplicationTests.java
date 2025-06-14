package com.lvhrts.microservices.product;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	// This connects your test to the running MongoDB test container
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	// Injects the random port your application started on
	@LocalServerPort
	private Integer port;

	// This static block starts the container before any tests run
	static {
		mongoDBContainer.start();
	}

	// This method runs BEFORE EACH @Test method
	@BeforeEach
	void setup() {
		// Set the base URI and port for all REST Assured calls in this class
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldCreateProduct() {
		// Now you can write your test logic using REST Assured
		// For example:
		String requestBody = """
				{
				    "name": "iPhone 15",
				    "description": "The latest iPhone",
				    "price": 999.99
				}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201); // 201 Created
	}
}