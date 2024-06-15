package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	//Create CRUD operations
	
	//Post Order
	public static Response createOrder(Store payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url_store);
		
		return response;
	}
	
	//Get user
	public static Response getOrder(int orderID)
	{
		Response response=given()
				.pathParam("orderID", orderID)
		
		.when()
		.get(Routes.get_url_store);
		
		return response;
	}
	
	//Delete Order
	
	public static Response deleteOrder(int orderID)
	{
		Response response=given()
				.pathParam("orderID", orderID)
				
				.when()
				.delete(Routes.delete_url_store);
		
		return response;
	}
	
	
	
	
	
	
	
	

}
