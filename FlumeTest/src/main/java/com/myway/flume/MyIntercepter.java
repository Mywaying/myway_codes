package com.myway.flume;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.List;
import java.util.Map;

/**
 * @author myway
 * @create 2020-07-19 10:44
 */
public class MyIntercepter implements Interceptor {

    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        Map<String, String> headers = event.getHeaders();

        byte[] logbytes = event.getBody();
        String log = new String(logbytes);
        boolean json = MyIntercepterUtil.isJson(log);
        if (json){
            headers.put("mytag","number");
        }else {
        }
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        for (Event event : list) {
            intercept(event);
        }
        return list;
    }

    @Override
    public void close() {

    }
    public static class MyBuilder implements Builder{

        @Override
        public Interceptor build() {
            return new MyIntercepter();
        }

        @Override
        public void configure(Context context) {


        }
    }
}
