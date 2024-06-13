package api.endpoints;
import static io.restassured.RestAssured.given;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//Created to perform the CRUD (Create, Read, Update, Delete) requests for the user API

public class UserEndPoints {
	
	//Create user
	public static Response createUser(User payload)
	{
		Response response=
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) //because API requires it
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	//Reading the User
	public static Response readUser(String username)
	{
		Response response=
		given()
		.pathParam("username", username)
		
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	
	//update User
	public static Response updateUser(String username, User payload)
	{
		Response response=
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) //because API requires it
		.body(payload)
		.pathParam("username", username)
		
		.when()
		.put(Routes.update_url);
		
		return response;
	}
	
	
	//Delete User
	public static Response deleteUser(String username)
	{
		Response response=
		given()
		.pathParam("username", username)
		
		.when()
		.delete(Routes.delete_url);
		
		return response;
	}
	
	
	
	
	
}
