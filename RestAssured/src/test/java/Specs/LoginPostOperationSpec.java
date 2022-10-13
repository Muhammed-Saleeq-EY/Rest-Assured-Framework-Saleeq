package Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LoginPostOperationSpec {


    public static RequestSpecification PostrequestSpecification  () {

        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/")
                .setBasePath("/api/login")
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL).build();

    }

    public static ResponseSpecification PostresponseSpecification (){

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

    }



}
