package com.n26.ApiActionsManager;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.n26.ExtentReportManager.ReportLogger;
import com.n26.enums.HeaderTypes;
import com.n26.enums.HttpStatusCode;

public class RestAssuredActions {

    public static Response post(Object request, String path) {
        StringWriter writerRequest;
        PrintStream stream;
        writerRequest = new StringWriter();
        stream = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(RequestSpecificationManager.postRequestSpec())
                .body(request)
                .filter(new RequestLoggingFilter(stream))
                .when().post(path)
                .then().spec(RequestSpecificationManager.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static Response put(Object request, String path) {
        StringWriter writerRequest;
        PrintStream stream;
        writerRequest = new StringWriter();
        stream = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(RequestSpecificationManager.postRequestSpec())
                .body(request)
                .filter(new RequestLoggingFilter(stream))
                .when().put(path)
                .then().spec(RequestSpecificationManager.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static Response delete(String path) {
        StringWriter writerRequest;
        PrintStream stream;
        writerRequest = new StringWriter();
        stream = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(RequestSpecificationManager.deleteByIdRequestSpec())
                .filter(new RequestLoggingFilter(stream))
                .when().delete(path)
                .then().spec(RequestSpecificationManager.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static Response deleteWithoutResponseHasJson(String path) {
        StringWriter writerRequest;
        PrintStream stream;
        writerRequest = new StringWriter();
        stream = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(RequestSpecificationManager.deleteByIdRequestSpec())
                .filter(new RequestLoggingFilter(stream))
                .when().delete(path)
                .then().spec(RequestSpecificationManager.getResponseSpecWithoutJson())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }


    public static Response get(String path) {
        StringWriter writerRequest;
        PrintStream stream;
        writerRequest = new StringWriter();
        stream = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(RequestSpecificationManager.getRequestSpec())
                .filter(new RequestLoggingFilter(stream))
                .when().get(path)
                .then().spec(RequestSpecificationManager.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static void validateResponse(String fieldName, Object actual, Object expected) {
        String message = "Assertion for "+fieldName+" Field";

        try {
            assertThat(actual, equalTo(expected));
            ReportLogger.logPass(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
        } catch (AssertionError assertionError) {
            ReportLogger.logFail(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
            Assert.fail("Actual value is "+actual+ " But Expected Value is : "+expected);
        }
    }

    public static void validateStatusCode(int actual, HttpStatusCode statusCode) {
        String message = "Assertion for Status Code";

        try {
            assertThat(actual, equalTo(statusCode.code));
            ReportLogger.logPass(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + statusCode.code);
        } catch (AssertionError assertionError) {
            ReportLogger.logFail(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + statusCode.code);
            Assert.fail("Actual value is "+actual+ " But Expected Value is : "+statusCode.code);
        }
    }

    public static void validateContentType(String actual, HeaderTypes contentType) {
        String message = "Assertion for Content Type";

        try {
            assertThat(actual, equalTo(contentType.type));
            ReportLogger.logPass(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + contentType.type);
        } catch (AssertionError assertionError) {
            ReportLogger.logFail(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + contentType.type);
            Assert.fail("Actual value is "+actual+ " But Expected Value is : "+contentType.type);
        }
    }


    private static void printDetailsInExtentReport(StringWriter writer, Response response) {
        ReportLogger.info("<details><summary><i><font> Request details: </font></i>" + "</summary>"
                + "<pre>" + writer.toString() + "</pre>" + "</details> \n");
        ReportLogger.info("<details><summary><i><font> Response details: </font></i>" + "</summary>"
                + "<pre>" + response.asString() + "</pre>" + "</details> \n");
    }
    
}
