package com.dma.example.rest.converter;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ResponseTime {
	
	@Test
	public void simpleExample(){

		String myJson = "{\"name\": \"iso-appprestador\",\"password\": \"BQCE8[UtPT5M;GGg\"}";
		
		RestAssured.baseURI = "http://wsodontoweb-h.sulamerica.br/api";

		Response response = given()
				.contentType("application/json")
				.body(myJson)
				.when()
				.post("/Token");

		String body = response.getBody().asString();
		System.out.println(body);
	}
	
}