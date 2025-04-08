package com.n26;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.n26.TestInitiator.BaseTest;
import com.n26.enums.HttpStatusCode;

import io.restassured.response.Response;

//   This test is to deliberately fail the test to see the result in extend reports

@Listeners(com.n26.CustomListener.TestngListener.class)
public class FailedUserTest extends BaseTest {
    int userId = 10;
    String username = "jatindandona";
    String firstName = "John";
    String lastName = "James";
    String email = "john@email.com";
    String password = "12345";
    String phone = "12345";
    int userStatus = 1;

    @Test(priority = 0)
    public void getUser_withInvalidData_errorInresponse() {

        Response response = testContext().getUserActions().getUserByUsername(username);
        testContext().getRestAssuredActions().validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);
    }
    
}
