package api.endpoints;

//We will maintain only the URL's in this class

public class Routes {
	
	public static String base_url ="https://petstore.swagger.io/v2";
	
	//End points for user modules
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	public static String post_url_store=base_url+"/store/order";
	public static String get_url_store = base_url +"/store/order/{orderID}";
	public static String delete_url_store =base_url+"/store/order/{orderID}";
	
	//Pet module
	public static String post_url_pet =base_url+"/pet";
	public static String get_url_pet = base_url +"/pet/{petID}";
	public static String update_url_pet= base_url+"/pet/{petID}";
	public static String delete_url_pet= base_url+"/pet/{petID}";
	
	
}
