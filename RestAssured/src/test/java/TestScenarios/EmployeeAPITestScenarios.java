package TestScenarios;

import API.EmployeeAPI;
import API.LoginAPI;
import POJOS.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeAPITestScenarios {

    LoginPositiveResponse Loginresponse;
    @Test
    public void addEmployee() {

        EmployeeAddress empAddress = new EmployeeAddress();
        EmployeeRequestBody empReqPayload = new EmployeeRequestBody();

        empAddress.setCountry("India");
        empAddress.setDistrict("Karanataka");
        empAddress.setPincode(695300);
        empReqPayload.setAddress(empAddress);
        empReqPayload.setFirstName("David");
        empReqPayload.setDesignation("QA");
        empReqPayload.setYearsOfExperience(5);
        empReqPayload.setLastName("Doe");

        LoginRequestBody reqPayload = new LoginRequestBody();
        reqPayload.setEmail("muhammed.saleeq@gds.ey.com");
        reqPayload.setPassword("12345678");

        Response Loginresponse = LoginAPI.ReqRestAPI(reqPayload);
        LoginPositiveResponse LoginPositiveresponse = Loginresponse.as(LoginPositiveResponse.class);

        String Token = LoginPositiveresponse.getToken();

        Response Empresponse = EmployeeAPI.ReqRestAPI(empReqPayload,Token);
        EmployeeSuccessResponse EmpPositiveresponse = Empresponse.as(EmployeeSuccessResponse.class);

        Assert.assertEquals(Empresponse.getStatusCode(),200);
        Assert.assertTrue(EmpPositiveresponse.getMessage().contains(empReqPayload.getFirstName()));
        Assert.assertTrue((EmpPositiveresponse.getEmployeeId().length())>0);

    }

    @Test
    public void inValidTokenValidation() {

        EmployeeAddress empAddress = new EmployeeAddress();
        EmployeeRequestBody empReqPayload = new EmployeeRequestBody();

        empAddress.setCountry("India");
        empAddress.setDistrict("Karanataka");
        empAddress.setPincode(695300);
        empReqPayload.setAddress(empAddress);
        empReqPayload.setFirstName("David");
        empReqPayload.setDesignation("QA");
        empReqPayload.setYearsOfExperience(5);
        empReqPayload.setLastName("Doe");

        //Not required
//         LoginRequestBody reqPayload = new LoginRequestBody();
//         reqPayload.setEmail("muhammed.saleeq@gds.ey.com");
//         reqPayload.setPassword("12345678");

//         Response Loginresponse = LoginAPI.ReqRestAPI(reqPayload);
//         LoginPositiveResponse LoginPositiveresponse = Loginresponse.as(LoginPositiveResponse.class);


        Response Empresponse = EmployeeAPI.ReqRestAPI(empReqPayload, "465777");
        EmployeeInvalidResponse employeeInvalidResponse = Empresponse.as(EmployeeInvalidResponse.class);

        Assert.assertEquals(Empresponse.getStatusCode(), 401);
        Assert.assertTrue(employeeInvalidResponse.getMessage().contains("Invalid auth token"));
        Assert.assertFalse(employeeInvalidResponse.getAuth());
    }









}
