package TestScenarios;

import API.LoginAPI;
import POJOS.LoginInvalidResponse;
import POJOS.LoginPositiveResponse;
import POJOS.LoginRequestBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTestScenarios {


    @Test
    public void LoginValidCred(){
        LoginRequestBody reqPayload = new LoginRequestBody();
        reqPayload.setEmail("muhammed.saleeq@gds.ey.com");
        reqPayload.setPassword("12345678");

        Response response = LoginAPI.ReqRestAPI(reqPayload);
        LoginPositiveResponse resposebody = response.as(LoginPositiveResponse.class);


        Assert.assertEquals(resposebody.getRole(), "admin");
        Assert.assertEquals(resposebody.getEmail(), "muhammed.saleeq@gds.ey.com");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue((resposebody.getToken().length())>0);
    }


    @Test
    public void LoginInValidEmail(){
        LoginRequestBody reqPayload = new LoginRequestBody();
        reqPayload.setEmail("muhammed.salee@gds.ey.com");
        reqPayload.setPassword("12345678");

        Response response = LoginAPI.ReqRestAPI(reqPayload);

        LoginInvalidResponse loginInvalidResponse = response.as(LoginInvalidResponse.class);
        Assert.assertEquals(response.getStatusCode(),401);

    }

    @Test
    public void LoginInValidPassword(){
        LoginRequestBody reqPayload = new LoginRequestBody();
        reqPayload.setEmail("muhammed.saleeq@gds.ey.com");
        reqPayload.setPassword("123456789");

        Response response = LoginAPI.ReqRestAPI(reqPayload);

        LoginInvalidResponse loginInvalidResponse = response.as(LoginInvalidResponse.class);
        Assert.assertEquals(response.getStatusCode(),401);

    }

}
