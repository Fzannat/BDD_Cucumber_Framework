package com.luma.bdd.qa.Utilities;

import java.util.Date;

public class Util {
    public static String generateEmailWithDateTimeStamp(){
        Date date = new Date();
        String dateStamp = date.toString().replace(" ", "_").replace(":", "_");
        return "fatema" + dateStamp + "@gmail.com";
    }


}
