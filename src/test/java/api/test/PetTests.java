package api.test;

import api.endpoints.PetEndPoints;
import api.payload.Pet;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PetTests {
    Faker faker;
    Pet payload;

    @BeforeClass
    public void SetupData(){
        faker = new Faker();

        payload = new Pet();
        payload.setId(faker.idNumber().hashCode());
        payload.setName(faker.name().username());

        Pet.Category fakeCategory = new Pet.Category();
        fakeCategory.setId(faker.idNumber().hashCode());
        fakeCategory.setName(faker.name().username());

        payload.setCategory(fakeCategory);

        payload.setPhotoUrls(new ArrayList<>(){});

        Pet.PetTag faketag = new Pet.PetTag();
        faketag.setId(faker.idNumber().hashCode());
        faketag.setName(faker.name().username());

        payload.setTag(faketag);
        payload.setStatus(Pet.PetStatus.available);
    }

    @Test(priority = 1)
    public void PostPet(){
        Response response = PetEndPoints.CreatePet(payload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200 );
    }

    @Test(priority = 2)
    public void GetPetById(){
        Response response = PetEndPoints.ReadPet(payload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200 );
    }

    @Test(priority = 3)
    public  void UpdatePetById(){
        Response response = PetEndPoints.UpdatePet( payload);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void DeletePetById(){
        Response response = PetEndPoints.DeletePet(payload.getId());

        Assert.assertEquals(response.getStatusCode(), 200);

        Response checkIfDeleted = PetEndPoints.ReadPet(payload.getId());

        Assert.assertEquals(checkIfDeleted.getStatusCode(), 404);
    }
}
