package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {
	
	public  static Response creatUser(User payload)
	{
		Response res=given()
		   .contentType(ContentType.JSON).accept((ContentType.JSON))
		   .body(payload)
		.when().post(Routes.post_url);
		
	return res;
	}
	
	public  static Response readUser(String userName)
	{
		Response res=given()
		          .pathParam("username",userName)
		.when().get(Routes.get_URL);
		
	return res;
	}
	
	public  static Response updateUser(String userName,User payload)
	{
		Response res=given()
				   .contentType(ContentType.JSON).accept((ContentType.JSON))
				   .body(payload).pathParam("username",userName)
				.when().put(Routes.update_URL);
		
	return res;
	}
	public  static Response deleteUser(String userName)
	{
		Response res=given()
		          .pathParams("username",userName)
		.when().delete(Routes.delete_URL);
		
	return res;
	}
	
	
}
