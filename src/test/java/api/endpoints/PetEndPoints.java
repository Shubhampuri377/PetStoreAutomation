package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	//Create the CRUD operation
	
	//Post pet in to the DB
	public static Response addPet(Pet payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)

		.when()
		.post(Routes.post_url_pet);
		return response;
	}
	
	//Get pet from the DB
	public static Response getPet(long petID)
	{
		Response response=given()
				.pathParam("petID", petID)
	
		.when().get(Routes.get_url_pet);
		return response;
	}
	
	/*//Update the Pet
	public static Response updatePet(Pet payload, long petID)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("petID", petID)

		.when()
		.post(Routes.update_url_pet);
		return response;
	}*/
	
	//Delete the Pet
	public static Response deletePet(long petID)
	{
		Response response=given()
				.pathParam("petID", petID)
	
		.when().get(Routes.delete_url_pet);
		return response;
	}

}
