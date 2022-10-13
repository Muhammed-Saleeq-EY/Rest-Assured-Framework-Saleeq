package API;

import Specs.EmployeeGetOperationSpec;
import Specs.EmployeePostOperationSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeletEmployeeAPI {

    public static Response ReqRestAPI (String Token, String EmpID){
        return given().spec(EmployeeGetOperationSpec.empPostrequestSpecification(Token,EmpID))
                .when()
                .delete()
                .then()
                .spec(EmployeePostOperationSpec.empPostresponseSpecification())
                .extract().response();
    }
}
