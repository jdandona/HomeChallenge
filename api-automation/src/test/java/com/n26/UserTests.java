package com.n26;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.n26.TestInitiator.BaseTest;
import com.n26.enums.HeaderTypes;
import com.n26.enums.HttpStatusCode;
import com.n26.requestModel.UserApiModel.CreateUserRequest;
import com.n26.requestModel.UserApiModel.UpdateUserRequest;
import com.n26.responseModel.GetUserResponse;
import com.n26.responseModel.UpdateUserResponse;

import io.restassured.response.Response;

@Listeners(com.n26.CustomListener.TestngListener.class)
public class UserTests extends BaseTest {

    int userId = 10;
    String username = "AutomationUser";
    String firstName = "John";
    String lastName = "James";
    String email = "john@email.com";
    String password = "12345";
    String phone = "12345";
    int userStatus = 1;

    String userUpdatedName = "John wick";
    String userNotFoundText = "User not found";

    @Test(priority = 0)
    public void createUser_withValidData_shouldCreatedSuccessfully() {

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setId(userId);
        createUserRequest.setUsername(username);
        createUserRequest.setFirstName(firstName);
        createUserRequest.setLastName(lastName);
        createUserRequest.setEmail(email);
        createUserRequest.setPassword(password);
        createUserRequest.setPhone(phone);
        createUserRequest.setUserStatus(userStatus);

        Response response = testContext().getUserActions().createUser(createUserRequest);
        testContext().getRestAssuredActions().validateContentType(response.contentType(), HeaderTypes.APPLICATION_JSON);
        testContext().getRestAssuredActions().validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);
    }
    
    @Test(priority = 1)
    public void getUserDetail_ByValidUsername() {
        Response response = testContext().getUserActions().getUserByUsername(username);
        testContext().getRestAssuredActions().validateContentType(response.contentType(), HeaderTypes.APPLICATION_JSON);
        testContext().getRestAssuredActions().validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);

        GetUserResponse responseData = response.as(GetUserResponse.class);
        testContext().getRestAssuredActions().validateResponse("Id", responseData.getId(), userId);
        testContext().getRestAssuredActions().validateResponse("Username", responseData.getUsername(), username);
    }

    @Test(priority = 2)
    public void updateUserDetail_withValidData_shouldBeUpdatedSuccessfully() {
        UpdateUserRequest updateUserResquest = new UpdateUserRequest();
        updateUserResquest.setId(userId);
        updateUserResquest.setUsername(userUpdatedName);
        updateUserResquest.setFirstName(firstName);
        updateUserResquest.setLastName(lastName);
        updateUserResquest.setEmail(email);
        updateUserResquest.setPassword(password);
        updateUserResquest.setPhone(phone);
        updateUserResquest.setUserStatus(userStatus);

        Response response = testContext().getUserActions().updateUserByUsername(updateUserResquest, username);
        testContext().getRestAssuredActions().validateContentType(response.contentType(), HeaderTypes.APPLICATION_JSON);
        testContext().getRestAssuredActions().validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);

        UpdateUserResponse responseData = response.as(UpdateUserResponse.class);

        testContext().getRestAssuredActions().validateResponse("Id", responseData.getId(), userId);
        testContext().getRestAssuredActions().validateResponse("Username", responseData.getUsername(), userUpdatedName);
    }
    

    @Test(priority = 3)
    public void deleteUser_withValidData_shouldBeDeletedSuccessfully() {
        Response response = testContext().getUserActions().deleteUserByUsername(userUpdatedName);
        testContext().getRestAssuredActions().validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);

        Response getResponse = testContext().getUserActions().getUserByUsername(userUpdatedName);
        testContext().getRestAssuredActions().validateContentType(getResponse.contentType(), HeaderTypes.APPLICATION_XML);
        testContext().getRestAssuredActions().validateStatusCode(getResponse.statusCode(), HttpStatusCode.STATUS404);
        testContext().getRestAssuredActions().validateResponse("Get Response Output ", getResponse.asString(), userNotFoundText);
    }

    
}
