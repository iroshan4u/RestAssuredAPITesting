package pkg_iro;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request {

	@Test
	void getUserDetails(){
		
		//Specifiy base URI
		RestAssured.baseURI = "https://reqres.in";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "Tom");
		requestParam.put("job", "Banker");
		
		httpRequest.header("Content-Type", "application/json");
		//attach data to request
		httpRequest.body(requestParam.toJSONString());
				
		//Response object
		Response response = httpRequest.request(Method.POST, "/api/users");
				
		
		//print response in console window
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is : \n" + responseBody);
		
		//status code verification
		int statusCode = response.getStatusCode();
		System.out.println("status code:" + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//success code validation
		String successName = response.jsonPath().get("name");
		Assert.assertEquals(successName, "Tom");
		
		
	}
}
