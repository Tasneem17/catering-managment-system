/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.helper;

import java.util.Random;

public class RepoHelper {
    public static boolean isNullorEmpty(String a){
        return  (a==null || a.equals(""));


    }
    public static boolean isEmpty( double b){

        return (b==0.0);
    }
    public static boolean IDisEmpty(int b){
        if (b==0 );
        return false;
    }

    public static int idgenerate() {

        Random rand = new Random();
        int randomNum = rand.nextInt((10000 - 1) + 1) + 1;
    //     i = randomNum;
        return randomNum;
    }
}
