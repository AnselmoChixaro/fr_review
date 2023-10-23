package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userPayload;

    public Logger logger;

    @BeforeClass
    public void setupData(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        //LOGS
         logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void PostUser(){

        logger.info("******** Creating User **************");
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("******** User Created **************");
    }

    @Test(priority = 2)
    public void GetUserByName(){

        logger.info("******** Reading User Info **************");
        Response response = UserEndPoints.readUser(userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******** User Info is Displayed **************");
    }

    @Test(priority = 3)
    public void UpdateUserByName(){

        logger.info("******** User Update **************");

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(userPayload.getUsername(), userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        //Checking the data after update
        Response responseAfterUpdate = UserEndPoints.readUser(userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

        logger.info("******** User Updated **************");
    }

    @Test(priority = 4)
    public void DeleteUserByName(){

        logger.info("******** Deleting the User **************");

        Response response = UserEndPoints.deleteUser(userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        Response responseAfterUpdate = UserEndPoints.readUser(userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 404);

        logger.info("******** Used Deleted **************");
    }
}
