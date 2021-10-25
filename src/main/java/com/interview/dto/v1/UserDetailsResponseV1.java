package com.interview.dto.v1;

import java.util.List;

/***
 * DTO used by associated User Service
 * @Author: Bharath Kumar Gadiyaram
 */
public class UserDetailsResponseV1 {
    UserDetails user;

    public UserDetails getUser() {
        return user;
    }

    public class UserDetails {
        String id;
        String name;
        List<ContactMethod> contact_methods;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<ContactMethod> getContact_methods() {
            return contact_methods;
        }

        public class ContactMethod {
            String id;
            String type;
            String summary;
            String self;
            String address;

            public String getAddress() {
                return address;
            }

            public String getId() {
                return id;
            }

            public String getType() {
                return type;
            }

            public String getSummary() {
                return summary;
            }

            public String getSelf() {
                return self;
            }
        }
    }
}




