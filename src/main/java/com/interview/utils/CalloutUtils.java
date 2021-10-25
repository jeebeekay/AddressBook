package com.interview.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
/***
 * Callout Utils for any API callouts
 * @Author: Bharath Kumar Gadiyaram
 */
public class CalloutUtils {

    @Value("${api.token}")
    String token;

    public String httpGetRequest(String url) throws IOException {
        URL url_obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) url_obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept", "application/vnd.pagerduty+json;version=2");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Token token="+token);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
