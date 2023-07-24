package api.endpoints;


/* here we maintain only URLs
 ==========================
 Swagger URI -->https://petstore.swagger.io
 create user(post)-->  https://petstore.swagger.io/v2/user
 get user (get)--> https://petstore.swagger.io/v2/user/{username}
 update user(put)==>https://petstore.swagger.io/v2/user/{username}
 delete user(Delete)==>https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	public static String base_URL= "https://petstore.swagger.io/v2";
	
	//User module routes or url's
	public static String post_url= base_URL+"/user";
	public static String get_URL= base_URL+"/user/{username}";
	public static String update_URL= base_URL+"/user/{username}";
	public static String delete_URL= base_URL+"/user/{username}";
	
	
	//store module
	
	//here you will create store module URL's

}
