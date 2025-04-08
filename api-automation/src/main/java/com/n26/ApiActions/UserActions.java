package com.n26.ApiActions;

import com.n26.ApiActionsManager.RestAssuredActions;
import com.n26.ApiActionsManager.UrlConstants;
import com.n26.requestModel.UserApiModel.CreateUserRequest;
import com.n26.requestModel.UserApiModel.UpdateUserRequest;

import io.restassured.response.Response;

public class UserActions {

    private RestAssuredActions restAssuredActions;

    public UserActions(RestAssuredActions restAssuredActions) {
        this.restAssuredActions = restAssuredActions;
    }

    public  Response createUser(CreateUserRequest createUser) {
        return restAssuredActions.post(createUser, UrlConstants.user);
    }

    public  Response getUserByUsername(String username){
        return restAssuredActions.get(UrlConstants.user+"/"+username);
    }
    
    public  Response deleteUserByUsername(String username) {
        return restAssuredActions.deleteWithoutResponseHasJson(UrlConstants.user + "/" + username);
    }
    
    public  Response updateUserByUsername(UpdateUserRequest updateUserResquest,String userName){
        return restAssuredActions.put(updateUserResquest, UrlConstants.user+"/"+userName);
    }
    
}
