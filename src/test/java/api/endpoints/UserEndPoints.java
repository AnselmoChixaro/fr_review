package api.endpoints;

/*
 * The class for perform the User CRUD
 */

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    static ResourceBundle getUrls(){
        return ResourceBundle.getBundle("routes");
    }

    public static Response createUser(User payload) {
        return given()
                  .contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .body(payload)
                  .when()
                  .post(getUrls().getString("post_user_url"));
    }

    public static Response readUser(String username) {

        return given()
                .pathParam("username", username)
                .when()
                .get(getUrls().getString("get_user_url"));
    }

    public static Response updateUser(String username, User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username", username)
                .body(payload)
                .when()
                .put(getUrls().getString("update_user_url"));
    }

    public static Response deleteUser(String username) {

        return given()
                .pathParam("username", username)
                .when()
                .delete(getUrls().getString("delete_user_url"));
    }
}
