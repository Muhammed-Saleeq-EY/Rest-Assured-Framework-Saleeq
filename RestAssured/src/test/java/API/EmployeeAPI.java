package API;

import POJOS.EmployeeRequestBody;
import POJOS.LoginRequestBody;
import Specs.EmployeePostOperationSpec;
import Specs.LoginPostOperationSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EmployeeAPI {

    public static Response ReqRestAPI (EmployeeRequestBody reqPayload, String Token){
        return given().spec(EmployeePostOperationSpec.empPostrequestSpecification(Token))
                .body(reqPayload)
                .when()
                .post()
                .then()
                .spec(EmployeePostOperationSpec.empPostresponseSpecification())
                .extract().response();
    }
}
