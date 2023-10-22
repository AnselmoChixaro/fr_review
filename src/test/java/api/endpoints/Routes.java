package api.endpoints;

/*
Swagger URI: https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user(Post) : https://petstore.swagger.io/v2/user/{username}
Update user(Post) : https://petstore.swagger.io/v2/user/{username}
Delete user(Post) : https://petstore.swagger.io/v2/user/{username}
*/

public class Routes {
    public static String base_url = "https://petstore.swagger.io/v2";

    //User Model End Points
    public static String post_user_url= base_url + "/user";
    public static String get_user_url= base_url + "/user/{username}";
    public static String update_user_url= base_url + "/user/{username}";
    public static String delete_user_url= base_url + "/user/{username}";

    //Pet module

    public  static String post_pet_url =  base_url + "/pet";
    public static String get_pet_url = base_url + "/pet/{petId}";
    public static String update_pet_url = base_url + "/pet";
    public static String delete_pet_url = base_url + "/pet/{petId}";
    //Store module

}
