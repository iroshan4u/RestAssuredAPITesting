package pkg_iro;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request {

	@Test
	void getUserDetails(){  
		
		//Specifiy base URI
		RestAssured.baseURI = "https://reqres.in";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		
		//print response in console window
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is : \n" + responseBody);
		
		//status code verification
		int statusCode = response.getStatusCode();
		System.out.println("status code:" + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		String statusLine = response.statusLine();
		System.out.println("Status Line is: " + statusLine);
		
	}
}
