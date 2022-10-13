package API;

import POJOS.LoginRequestBody;
import Specs.LoginPostOperationSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginAPI {

    public static Response ReqRestAPI (LoginRequestBody reqPayload){
       return given().spec(LoginPostOperationSpec.PostrequestSpecification())
                .body(reqPayload)
                .when()
                .post()
                .then()
                .spec(LoginPostOperationSpec.PostresponseSpecification())
               .extract().response();
    }
}
