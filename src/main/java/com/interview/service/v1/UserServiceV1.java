package com.interview.service.v1;

import com.interview.dto.v1.UserDetailsResponseV1;
import com.interview.dto.v1.UserListResponseV1;
import com.interview.utils.CalloutUtils;
import com.interview.utils.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
/***
 * Class used to service user details.
 * @Author: Bharath Kumar Gadiyaram.
 */
public class UserServiceV1 {
    private GeneralUtils generalUtils;

    private CalloutUtils calloutUtils;

    @Value("${api.base_url}")
    String baseURL;

    @Value("${api.user_list_uri}")
    String userListURI;

    @Value("${api.user_details_uri}")
    String userDetailsURI;

    public UserListResponseV1 listUsers(int page) throws IOException {
        int offset = page*GeneralUtils.PAGE_SIZE;
        String url = baseURL + userListURI + "?offset="+offset;
        String response = calloutUtils.httpGetRequest(url);
        UserListResponseV1 userListResponse = generalUtils.parseJsonToObject(response, UserListResponseV1.class);
        return userListResponse;
    }

    public UserDetailsResponseV1 getUserDetails(String id) throws IOException {
        String url = baseURL + userDetailsURI+"/"+id+"?include[]=contact_methods";
        String response = calloutUtils.httpGetRequest(url);
        UserDetailsResponseV1 userDetailsResponse = generalUtils.parseJsonToObject(response, UserDetailsResponseV1.class);
        return userDetailsResponse;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public void setUserListURI(String userListURI) {
        this.userListURI = userListURI;
    }

    @Autowired
    public void setGeneralUtils(GeneralUtils utils) {
        this.generalUtils = utils;
    }

    @Autowired
    public void setCalloutUtils(CalloutUtils calloutUtils) {
        this.calloutUtils = calloutUtils;
    }
}
