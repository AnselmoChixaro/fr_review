package api.endpoints;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndPoints {

    public static Response CreatePet(Pet payload){
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_pet_url);
    }

    public static Response ReadPet(Integer petId){
        return given()
                .pathParam("petId", petId)
                .when()
                .get(Routes.get_pet_url);
    }

    public static Response UpdatePet(Pet payload){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.update_pet_url);
    }

    public static Response DeletePet(Integer petId){
        return given()
                .pathParam("petId", petId)
                .when()
                .delete(Routes.delete_pet_url);
    }
}
