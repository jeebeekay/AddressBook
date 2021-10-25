package com.interview.dto.v1;

import java.util.List;

/***
 * DTO used by associated User Service
 * @Author: Bharath Kumar Gadiyaram
 */
public class UserListResponseV1 {
    List<User> users;
    int limit;
    int offset;
    String total;
    boolean more;

    public List<User> getUsers() {
        return users;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public String getTotal() {
        return total;
    }

    public boolean isMore() {
        return more;
    }

    public class User {
        String name;
        String email;
        String id;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }
}


