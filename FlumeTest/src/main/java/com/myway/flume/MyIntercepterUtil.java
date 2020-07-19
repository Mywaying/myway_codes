package com.myway.flume;

import com.google.gson.Gson;
import org.apache.avro.data.Json;

/**
 * @author myway
 * @create 2020-07-19 10:50
 */
public  class MyIntercepterUtil{
    public static boolean isJson(String log){

        Gson gson = new Gson();
        try {
            gson.fromJson(log, Json.class);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String log = "{\"name\":\"李四\",\"age\":27,\"sex\"}";

        boolean json = isJson(log);
        System.out.println(json);
    }

}
