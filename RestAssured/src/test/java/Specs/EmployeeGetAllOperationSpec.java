package Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EmployeeGetAllOperationSpec {

    public static RequestSpecification empPostrequestSpecification  (String Token) {

        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/")
                .setBasePath("/api/employees")
                .setRelaxedHTTPSValidation()
                .addHeader("x-access-token",Token)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL).build();

    }

    public static ResponseSpecification empPostresponseSpecification (){

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
}}
