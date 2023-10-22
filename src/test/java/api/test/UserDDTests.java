package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.UserDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserDDTests {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = UserDataProvider.class)
    public void DDCreateUsers(String userId, String userName, String fName, String lName, String email, String pwd, String ph) {
        User userPayload = new User();

        userPayload.setId(Integer.parseInt(userId));
        userPayload.setUsername(userName);
        userPayload.setFirstName(fName);
        userPayload.setLastName(lName);
        userPayload.setEmail(email);
        userPayload.setPassword(pwd);
        userPayload.setPhone(pwd);

        Response response = UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = UserDataProvider.class)
    public  void DDDeleteUsers(String userName){
        Response response = UserEndPoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
