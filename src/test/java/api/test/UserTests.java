package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	//Post User
	//Get User
	//Update User
	//Delete User
	Faker faker=new Faker();
	User userPayload=new User();
	public Logger logger;
	
	@BeforeClass()
	public void setupData()
	{
	
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());				
	
	//Setup logger
	logger= LogManager.getLogger(this.getClass());
	
	
	}
	
	@Test(priority = 1)
	public void testPostUser()
	{
		
		logger.info("************ Creating User ******************");
		Response response=UserEndPoints.createUser(userPayload);
	
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);		
		logger.info("************ User Created ******************");
	}
	
	@Test(priority = 2)
	public void getUserByName()
	{
		logger.info("************ Reading User Info ******************");
		Response response= UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("************ User info is Displayed ******************");
	}
	
	@Test(priority=3)
	public void updateUserByName()
	{
		
		logger.info("************ Updating User ******************");
		
		//Update these fields
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
	
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	
		//Check data after update
		Response responseafterupdate= UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseafterupdate.statusCode(), 200);
		logger.info("************ User Updated ******************");
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("************ Deleting User ******************");
		
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().statusCode(200).log().all();
		logger.info("************ User Deleted ******************");
	}
	
	
	
	
	
	
	
}
