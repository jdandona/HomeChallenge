package com.n26.ApiActions;

import com.n26.ApiActionsManager.RestAssuredActions;
import com.n26.ApiActionsManager.UrlConstants;
import com.n26.requestModel.UserApiModel.CreateUserRequest;
import com.n26.requestModel.UserApiModel.UpdateUserRequest;

import io.restassured.response.Response;

public class UserActions {

    public static Response createUser(CreateUserRequest createUser) {
        return RestAssuredActions.post(createUser, UrlConstants.user);
    }

    public static Response getUserByUsername(String username){
        return RestAssuredActions.get(UrlConstants.user+"/"+username);
    }
    
    public static Response deleteUserByUsername(String username) {
        return RestAssuredActions.deleteWithoutResponseHasJson(UrlConstants.user + "/" + username);
    }
    
    public static Response updateUserByUsername(UpdateUserRequest updateUserResquest,String userName){
        return RestAssuredActions.put(updateUserResquest, UrlConstants.user+"/"+userName);
    }
    
}
