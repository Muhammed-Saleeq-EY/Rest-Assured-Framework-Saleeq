package API;

import POJOS.EmployeeRequestBody;
import Specs.EmployeeGetOperationSpec;
import Specs.EmployeePostOperationSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EmployeeGetApi {

    public static Response ReqRestAPI ( String Token, String EmpID){
        return given().spec(EmployeeGetOperationSpec.empPostrequestSpecification(Token,EmpID))
                .when()
                .get()
                .then()
                .spec(EmployeePostOperationSpec.empPostresponseSpecification())
                .extract().response();
    }
}
