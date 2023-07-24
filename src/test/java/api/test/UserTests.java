package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payloads.User;
import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;

public class UserTests {
	Faker fak;
	User userpayload;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		
		fak = new Faker();
		 userpayload=new User();
		 userpayload.setId(fak.idNumber().hashCode());
		 userpayload.setUsername(fak.name().username());
		 userpayload.setLastname(fak.name().lastName());
		 userpayload.setFirstName(fak.name().firstName());
		 userpayload.setEmail(fak.internet().safeEmailAddress());
		 userpayload.setPassword(fak.internet().password(5,10));
		 userpayload.setPhone(fak.phoneNumber().cellPhone());
		 
		 //log
		// logger = LogManager.getLogger(UserTests.class);
	}
	@Test(priority=1)
   public void testPostUser(){
	   Response res=UserEndPoint.creatUser(userpayload);
	   res.then().log().all();
	   Assert.assertEquals(res.getStatusCode(),200);
   }
	@Test(priority=2)
	   public void testgetUser(){
		Response res=  UserEndPoint.readUser(this.userpayload.getUsername());
		   res.then().log().all();
		   Assert.assertEquals(res.getStatusCode(),200);
	   }
	
	@Test(priority=3)
	   public void testUpdateUser(){
		
		//upadte payload
		 userpayload.setLastname(fak.name().lastName());
		 userpayload.setFirstName(fak.name().firstName());
		 userpayload.setEmail(fak.internet().safeEmailAddress());
		Response res=  UserEndPoint.updateUser(this.userpayload.getUsername(),userpayload);
		   res.then().log().all();
		   Assert.assertEquals(res.getStatusCode(),200);
		   //checking data after update
			Response resafterupdate=  UserEndPoint.readUser(this.userpayload.getUsername());
			   res.then().log().all();
			   Assert.assertEquals(resafterupdate.getStatusCode(),200);
	   }
	
	@Test(priority=4)
	   public void testDeleteUser(){
	
		Response res=  UserEndPoint.deleteUser(this.userpayload.getUsername());
		   Assert.assertEquals(res.getStatusCode(),200);
	   }
}
