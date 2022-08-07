package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static boolean isNullorEmpty(String s){
        return (s == null || s.equals("")|| s.isEmpty()|| s.equalsIgnoreCase("null"));

    }
    public static String generateID(){

        return UUID.randomUUID().toString();
    }
    public static boolean isEmpty(double b) {

        return (b == 0.0);
    }
}

