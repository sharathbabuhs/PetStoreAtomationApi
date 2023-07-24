package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointUingpropertifile {
	
	// method created for getting URL from properties file 
	static ResourceBundle  getURL()
	{
		ResourceBundle routes= ResourceBundle.getBundle("routes");//load properties file.
		return routes;
	}
	
	public  static Response creatUser(User payload)
	{
		String posturl = getURL().getString("post_url");
		Response res=given()
		   .contentType(ContentType.JSON).accept((ContentType.JSON))
		   .body(payload)
		.when().post(posturl);
		
	return res;
	}
	
	public  static Response readUser(String userName)
	{
		String geturl = getURL().getString("get_URL");
		Response res=given()
		          .pathParam("username",userName)
		.when().get(geturl);
		
	return res;
	}
	
	public  static Response updateUser(String userName,User payload)
	{
		String Updateurl = getURL().getString("update_URL");
		Response res=given()
				   .contentType(ContentType.JSON).accept((ContentType.JSON))
				   .body(payload).pathParam("username",userName)
				.when().put(Updateurl);
		
	return res;
	}
	public  static Response deleteUser(String userName)
	{
		String deleteurl = getURL().getString("delete_URL");
		Response res=given()
		          .pathParams("username",userName)
		.when().delete(deleteurl);
		
	return res;
	}
	
	
}
