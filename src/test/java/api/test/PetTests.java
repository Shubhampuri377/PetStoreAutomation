package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class PetTests {
	
	//Tests to perform on different requests
	SoftAssert sa=new SoftAssert();
	Faker faker=new Faker();
	Pet payload=new Pet();
	Logger logger;
	long petID;
	
	@BeforeClass
	public void setupData()
	{
		logger= LogManager.getLogger();
		
		payload.setName(faker.animal().name());	
	}
	
    @AfterTest
	public void softassertflush()
	{
		sa.assertAll();
	}
	
	//Add pet
	@Test(priority = 1)
	public void testAddPet()
	{
		logger.info("************ Adding Pet **************");
		
		Response response=PetEndPoints.addPet(this.payload);
		petID = response.jsonPath().getLong("id");
		System.out.println("Pet order ID number is: "+ petID);
		response.then().log().all();
		sa.assertEquals(response.statusCode(), 200);
		sa.assertEquals(response.jsonPath().getLong("id"), petID);
		
		logger.info("************ Pet Added **************");
	}
	
	//Get pet Details
	@Test(priority = 2)
	public void getPet()
	{
		logger.info("************ Getting Pet **************");
		Response response=PetEndPoints.getPet(petID);
		response.then().log().all();
		sa.assertEquals(response.statusCode(), 200);
		logger.info("************ Pet Fetched **************");
	}
	
	/*//Update pet
	@Test(priority = 3)
	public void updatePet()
	{
		logger.info("************ Updating Pet Name**************");
		
		payload.setName(faker.animal().name());	
		payload.setStatus("unavailable");
		
		Response response=PetEndPoints.updatePet(payload, petID);
		response.then().log().all();
		sa.assertEquals(response.statusCode(), 200);
		
		logger.info("************ Pet Name Updated **************");
		
	}*/
	
	//Delete pet
	@Test(priority = 4)
	public void deletePet()
	{
		logger.info("************ Deleting Pet **************");
		Response response=PetEndPoints.deletePet(petID);
		response.then().log().all();
		sa.assertEquals(response.statusCode(), 200);
		
		logger.info("************ Pet Deleted **************");
	}
	
	
	
	
	
	

}
