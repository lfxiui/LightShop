package com.tools;

/**
 * Created by AgZou on 2017/5/30.
 */
public class ColorUtil {

   static char[] array={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public  static String ranColor(){
        String c="#";

       for(int i=0;i<6;i++) {
           Long a= Math.round(Math.random()*15);
           c += array[a.intValue()];
       }
       return c;
    }
}
