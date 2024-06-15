package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

import api.utilities.Dataproviders;

public class DDTests {
	
	//Create multiple users by using Excel and data provider
	//Then delete all the created users by using only username
	Logger logger;
	
	@Test(priority = 1, dataProvider = "Data",dataProviderClass = Dataproviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph)
	{
		logger= LogManager.getLogger(this.getClass());
		logger.info("************* Creating User Data Driven Testing started ****************");
		
		
		User userPayload= new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);	
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);		
		
		logger.info("************* Creating User Data Driven Testing Ended ****************");
		
	}
	@Test(priority = 2,dataProvider ="UserNames",dataProviderClass = Dataproviders.class)
	public void testDeleteUserByName(String username)
	{
		logger.info("************* Deleting User by Name Data Driven Testing Started ****************");
		
		Response response=UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* Deleting user by Name Data Driven Testing Ended ****************");
		
	}

}
