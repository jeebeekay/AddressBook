package com.interview.application.service;

import com.interview.dto.v1.UserDetailsResponseV1;
import com.interview.dto.v1.UserListResponseV1;
import com.interview.service.v1.UserServiceV1;
import com.interview.utils.CalloutUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class UserServiceV1Test {

    private static final String LIST_USER_PAYLOAD = "{'users':[{'name':'Alan B. Shepard, Jr.','email':'alan.shepard@nasa.example','time_zone':'America/Los_Angeles','color':'blue-violet','avatar_url':'https://secure.gravatar.com/avatar/e58b7fdfb50566fd0334b360a05b729c.png?d=mm&r=PG','billed':true,'role':'limited_user','description':null,'invitation_sent':true,'job_title':null,'teams':[{'id':'PQZPQGI','type':'team_reference','summary':'North American Space Agency (NASA)','self':'https://api.pagerduty.com/teams/PQZPQGI','html_url':'https://pdt-apidocs.pagerduty.com/teams/PQZPQGI'}],'contact_methods':[{'id':'PSMLP14','type':'email_contact_method','summary':'Default','self':'https://api.pagerduty.com/users/PLOASXQ/contact_methods/PSMLP14','html_url':null,'label':'Default','address':'alan.shepard@nasa.example','send_short_email':false,'send_html_email':true},{'id':'P3W47MP','type':'phone_contact_method','summary':'Work','self':'https://api.pagerduty.com/users/PLOASXQ/contact_methods/P3W47MP','html_url':null,'label':'Work','address':'1115550001','blacklisted':false,'country_code':1},{'id':'PBXT65T','type':'sms_contact_method','summary':'Mobile','self':'https://api.pagerduty.com/users/PLOASXQ/contact_methods/PBXT65T','html_url':null,'label':'Mobile','address':'1115550002','blacklisted':false,'country_code':1,'enabled':true}],'notification_rules':[{'id':'PJGOM3Q','type':'assignment_notification_rule_reference','summary':'0 minutes: channel PSMLP14','self':'https://api.pagerduty.com/users/PLOASXQ/notification_rules/PJGOM3Q','html_url':null},{'id':'P0K2LG6','type':'assignment_notification_rule_reference','summary':'0 minutes: channel PSMLP14','self':'https://api.pagerduty.com/users/PLOASXQ/notification_rules/P0K2LG6','html_url':null},{'id':'PKWQ7KR','type':'assignment_notification_rule_reference','summary':'0 minutes: channel P3W47MP','self':'https://api.pagerduty.com/users/PLOASXQ/notification_rules/PKWQ7KR','html_url':null},{'id':'PW2553L','type':'assignment_notification_rule_reference','summary':'0 minutes: channel PBXT65T','self':'https://api.pagerduty.com/users/PLOASXQ/notification_rules/PW2553L','html_url':null}],'coordinated_incidents':[],'id':'PLOASXQ','type':'user','summary':'Alan B. Shepard, Jr.','self':'https://api.pagerduty.com/users/PLOASXQ','html_url':'https://pdt-apidocs.pagerduty.com/users/PLOASXQ'}],'limit':25,'offset':0,'total':null,'more':true}";
    private static final String USER_DETAILS_PAYLOAD = "{'user':{'name':'T. Keith Glennan','email':'keith.glennan@nasa.example','time_zone':'America/Los_Angeles','color':'steel-blue','avatar_url':'https://secure.gravatar.com/avatar/88aaf0e0f1c11a943e8c92ca012c62e9.png?d=mm&r=PG','billed':true,'role':'user','description':null,'invitation_sent':true,'job_title':null,'teams':[{'id':'PQZPQGI','type':'team_reference','summary':'North American Space Agency (NASA)','self':'https://api.pagerduty.com/teams/PQZPQGI','html_url':'https://pdt-apidocs.pagerduty.com/teams/PQZPQGI'}],'contact_methods':[{'id':'PD6Q835','type':'email_contact_method','summary':'Default','self':'https://api.pagerduty.com/users/PT84P1X/contact_methods/PD6Q835','html_url':null,'label':'Default','address':'keith.glennan@nasa.example','send_short_email':false,'send_html_email':true},{'id':'P6JUSTG','type':'phone_contact_method','summary':'Work','self':'https://api.pagerduty.com/users/PT84P1X/contact_methods/P6JUSTG','html_url':null,'label':'Work','address':'1115550042','blacklisted':false,'country_code':1},{'id':'PIX4RPN','type':'sms_contact_method','summary':'Mobile','self':'https://api.pagerduty.com/users/PT84P1X/contact_methods/PIX4RPN','html_url':null,'label':'Mobile','address':'1115550042','blacklisted':false,'country_code':1,'enabled':true}],'notification_rules':[{'id':'PBJ7EZY','type':'assignment_notification_rule_reference','summary':'0 minutes: channel PD6Q835','self':'https://api.pagerduty.com/users/PT84P1X/notification_rules/PBJ7EZY','html_url':null},{'id':'PFVVFOL','type':'assignment_notification_rule_reference','summary':'0 minutes: channel PD6Q835','self':'https://api.pagerduty.com/users/PT84P1X/notification_rules/PFVVFOL','html_url':null},{'id':'PI8JJWP','type':'assignment_notification_rule_reference','summary':'0 minutes: channel P6JUSTG','self':'https://api.pagerduty.com/users/PT84P1X/notification_rules/PI8JJWP','html_url':null},{'id':'PTEBGCJ','type':'assignment_notification_rule_reference','summary':'0 minutes: channel PIX4RPN','self':'https://api.pagerduty.com/users/PT84P1X/notification_rules/PTEBGCJ','html_url':null}],'coordinated_incidents':[],'id':'PT84P1X','type':'user','summary':'T. Keith Glennan','self':'https://api.pagerduty.com/users/PT84P1X','html_url':'https://pdt-apidocs.pagerduty.com/users/PT84P1X'}}";

    @MockBean
    private CalloutUtils calloutUtils;


    @Autowired
    private UserServiceV1 userService;

    @Test
    public void testUserListCall() throws IOException {
        given(this.calloutUtils.httpGetRequest(anyString())).willReturn(LIST_USER_PAYLOAD);
        UserListResponseV1 response = this.userService.listUsers(1);
        assertEquals(25, response.getLimit());
        assertEquals(0, response.getOffset());
        assertEquals(1, response.getUsers().size());
        UserListResponseV1.User user = response.getUsers().get(0);
        assertTrue(user.getName().equals("Alan B. Shepard, Jr."));
        assertTrue(user.getEmail().equals("alan.shepard@nasa.example"));
    }

    @Test
    public void testUserDetailsCall() throws IOException {
        given(this.calloutUtils.httpGetRequest(anyString())).willReturn(USER_DETAILS_PAYLOAD);
        UserDetailsResponseV1 response = this.userService.getUserDetails(anyString());
        UserDetailsResponseV1.UserDetails details =  response.getUser();
        assertTrue(details.getId().equals("PT84P1X"));
        assertTrue(details.getName().equals("T. Keith Glennan"));
        assertEquals(3, details.getContact_methods().size());
        assertTrue(details.getContact_methods().get(0).getType().equals("email_contact_method"));
        assertTrue(details.getContact_methods().get(0).getId().equals("PD6Q835"));
        assertTrue(details.getContact_methods().get(0).getAddress().equals("keith.glennan@nasa.example"));
        assertTrue(details.getContact_methods().get(0).getSummary().equals("Default"));
    }


}
