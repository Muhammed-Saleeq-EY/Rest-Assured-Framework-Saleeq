package API;

import Specs.EmployeeGetAllOperationSpec;
import Specs.EmployeeGetOperationSpec;
import Specs.EmployeePostOperationSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAllEmployeeAPI {

    public static Response ReqRestAPI (String Token){
        return given().spec(EmployeeGetAllOperationSpec.empPostrequestSpecification(Token))
                .when()
                .get()
                .then()
                .spec(EmployeeGetAllOperationSpec.empPostresponseSpecification())
                .extract().response();
    }
}
