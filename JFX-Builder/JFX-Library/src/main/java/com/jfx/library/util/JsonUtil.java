package com.jfx.library.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Reza
 */
public class JsonUtil {
    
    public static Map<String, Object> JsonToMap(String value) {
        Map<String, Object> result = new HashMap<>();
        try {
            Gson gson = new Gson();
            result = (Map)gson.fromJson(value, Map.class);
        }
        catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        }
        return result;
    }

     public static List<Map<String, Object>> JsonFileToListMap(BufferedReader value) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Type typeOf = new TypeToken<List<Map<String, Object>>>(){}.getType();
            result = gson.fromJson(value, typeOf);
        }
        catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static String MapToJson(Map<String, Object> value) {
        String result = null;
        try {
            Gson gson = new Gson();
            result = gson.toJson(value);
        }
        catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}