package edu.hbuas.cake.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateOrderNumber {
    public static String createNumber(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0; i<4; i++){
            result += random.nextInt(10);
        }
        return newDate + result;
    }


}
