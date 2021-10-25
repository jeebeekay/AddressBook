package com.interview.utils;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;

@Component
/***
 * General Utils catch all class.
 * @Author Bharath Kumar Gadiyaram.
 */
public class GeneralUtils {

    public static int PAGE_SIZE = 25;

    public Map parseJsonToMap(String jsonStr) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, Map.class);
    }

    public <T> T parseJsonToObject(String jsonStr, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, clazz);
    }

    public String readKeyboardInputFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
