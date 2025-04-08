package com.n26.ApiActionsManager;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationManager {

    public static RequestSpecification postRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(UrlConstants.BASE_URL)
                .setBasePath(UrlConstants.API_VERSION)
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(UrlConstants.BASE_URL)
                .setBasePath(UrlConstants.API_VERSION)
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification deleteByIdRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(UrlConstants.BASE_URL)
                .setBasePath(UrlConstants.API_VERSION)
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpecWithoutJson(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
    
}
