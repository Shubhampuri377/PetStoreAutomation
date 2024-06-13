package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//Created to perform the CRUD (Create, Read, Update, Delete) requests for the user API

public class UserEndPoints2 {
	
	//Code to load properties file
	//By using the ResourceBundle or Properties class
	
	public static ResourceBundle getURL()
	{
		ResourceBundle routes= ResourceBundle.getBundle("Routes"); //name of the properties file
		
		return routes;
	}
	
	
	//Create user
	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");
			
		Response response=
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) //because API requires it
		.body(payload)
		
		.when()
		.post(post_url);
		
		return response;
	}
	
	//Reading the User
	public static Response readUser(String username)
	{
		String get_url=getURL().getString("get_url");
		
		Response response=
		given()
		.pathParam("username", username)
		
		.when()
		.get(get_url);
		
		return response;
	}
	
	//update User
	public static Response updateUser(String username, User payload)
	{
		String update_url=getURL().getString("update_url");
		
		Response response=
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) //because API requires it
		.body(payload)
		.pathParam("username", username)
		
		.when()
		.put(update_url);
		
		return response;
	}
	
	
	//Delete User
	public static Response deleteUser(String username)
	{
		String delete_url=getURL().getString("delete_url");
		
		Response response=
		given()
		.pathParam("username", username)
		
		.when()
		.delete(delete_url);
		
		return response;
	}
	
	
	
	
	
}
