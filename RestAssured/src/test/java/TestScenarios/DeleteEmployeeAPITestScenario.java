package TestScenarios;

import API.*;
import POJOS.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEmployeeAPITestScenario {

    @Test
    public void deleteEmployeeAPI() {
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

    String EmpId = EmpPositiveresponse.getEmployeeId();

    Response EmpDeleteresponse = DeletEmployeeAPI.ReqRestAPI(Token,EmpId);
    EmployeeDeleteSuccessResponse EmployeeDeleteSuccessResponse = EmpDeleteresponse.as(EmployeeDeleteSuccessResponse.class);

    Assert.assertEquals(EmpDeleteresponse.getStatusCode(), 200);
}

}
