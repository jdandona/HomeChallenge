package com.n26;

import org.testng.annotations.Test;

import com.n26.ApiActions.UserActions;
import com.n26.ApiActionsManager.RestAssuredActions;
import com.n26.enums.HeaderTypes;
import com.n26.enums.HttpStatusCode;
import com.n26.requestModel.UserApiModel.CreateUserRequest;
import com.n26.requestModel.UserApiModel.UpdateUserRequest;
import com.n26.responseModel.GetUserResponse;
import com.n26.responseModel.UpdateUserResponse;

import io.restassured.response.Response;

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

        Response response = UserActions.createUser(createUserRequest);
        RestAssuredActions.validateContentType(response.contentType(), HeaderTypes.APPLICATION_JSON);
        RestAssuredActions.validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);
    }
    
    @Test(priority = 1)
    public void getUserDetail_ByValidUsername() {
        Response response = UserActions.getUserByUsername(username);
        RestAssuredActions.validateContentType(response.contentType(), HeaderTypes.APPLICATION_JSON);
        RestAssuredActions.validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);

        GetUserResponse responseData = response.as(GetUserResponse.class);
        RestAssuredActions.validateResponse("Id", responseData.getId(), userId);
        RestAssuredActions.validateResponse("Username", responseData.getUsername(), username);
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

        Response response = UserActions.updateUserByUsername(updateUserResquest,username);
        RestAssuredActions.validateContentType(response.contentType(), HeaderTypes.APPLICATION_JSON);
        RestAssuredActions.validateStatusCode(response.statusCode(), HttpStatusCode.STATUS200);

        UpdateUserResponse responseData = response.as(UpdateUserResponse.class);

        RestAssuredActions.validateResponse("Id",responseData.getId(), userId);
        RestAssuredActions.validateResponse("Username",responseData.getUsername(), userUpdatedName);
    }

    
}
