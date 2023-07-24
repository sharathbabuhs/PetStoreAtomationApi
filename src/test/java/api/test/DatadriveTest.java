package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payloads.User;
import api.utilites.DataProviders;
import io.restassured.response.Response;

public class DatadriveTest {
	
	//Here we use dataprovider not pojo class to provide data.
	@Test(priority=1,dataProvider="data",dataProviderClass=DataProviders.class)
	public void testPostUserDD(String UserID,String UserName,String FN,String LN,String Email,String Pwd,String Ph)
	{
		User  userpayload=new User();
		userpayload.setUsername(UserName);
		userpayload.setFirstName(FN);
		userpayload.setLastname(LN);
		userpayload.setEmail(Email);
		userpayload.setPassword(Pwd);
		userpayload.setPhone(Ph);
		Response res=UserEndPoint.creatUser(userpayload);
		   res.then().log().all();
		   Assert.assertEquals(res.getStatusCode(),200);
	}
	@Test(priority=2,dataProvider="UserName",dataProviderClass=DataProviders.class)
	public void testDeleteuserByName(String username)
	{
		Response res=  UserEndPoint.deleteUser(username);
		   Assert.assertEquals(res.getStatusCode(),200);
	}

}
