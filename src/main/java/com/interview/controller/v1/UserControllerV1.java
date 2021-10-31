package com.interview.controller.v1;


import com.interview.dto.v1.UserDetailsResponseV1;
import com.interview.dto.v1.UserListResponseV1;
import com.interview.service.v1.UserServiceV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
/***
 * Controller to expose REST end points for interacting with users.
 * @Author: Bharath Kumar Gadiyaram
 */
public class UserControllerV1 {

    public static Logger logger = LoggerFactory.getLogger(UserControllerV1.class);

    @Autowired
    UserServiceV1 userService;

    @GetMapping("/v1/users/list")
    public UserListResponseV1 getUsers(@RequestParam(value = "page")int page) throws IOException {
        logger.info("requesting users for page: " + page);
        return userService.listUsers(page);
    }

    @GetMapping("/v1/user/{id}")
    public UserDetailsResponseV1 getUserDetails(@PathVariable(value = "id")String id) throws IOException {
        logger.info("requesting users details for: " + id);
        return userService.getUserDetails(id);
    }
}
