package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {

	//we will do CRUD operations in this module as well
	
	Store payload=new Store();
	Faker faker=new Faker();
	Logger logger;
	int orderID;
	
	@BeforeClass
	public void setupData()
	{
		logger= LogManager.getLogger(this.getClass());
		
		payload.setPetID(faker.number().numberBetween(1, 10));
		payload.setQuantity(faker.number().numberBetween(1, 1000));
		payload.setShipDate(faker.number().numberBetween(2000, 2025));	
		
	}
	
	@Test(priority = 1)
	public void testPostOrder()
	{
		logger.info("************* Creating order ****************");
		
		Response response=StoreEndPoints.createOrder(this.payload);
		
		logger.info("************* Fetching order ID****************");
		orderID=response.jsonPath().getInt("id");
		logger.info("************* Order ID Fetched****************");
		response.then().log().all();
		
		logger.info("************* Order created ****************");
		
	}
	
	
	@Test(priority = 2)
	public void testGetOrder()
	
	{
		logger.info("************* Getting order by ID****************");
		Response response=StoreEndPoints.getOrder(orderID);
		response.then().statusCode(200).log().all();
		logger.info("************* Got Order Details****************");
	}
	
	@Test(priority=3)
	public void testdeleteOrder()
	{
		logger.info("************* Deleting order by ID****************");
		Response response=StoreEndPoints.deleteOrder(orderID);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* Order Deleted by ID****************");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
