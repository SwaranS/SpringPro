package com.springapp.mvc.services.time;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Locale;

/**
 * Created by Home on 10/02/2015.
 */
public class JodaExamples {
    private static final String pattern = "E MM/dd/yyyy HH:mm:ss.SSS";
    public static void main(String[] args) {
        DateTime dateTime = new DateTime(DateTimeZone.UTC);

        DateTimeZone timeZone = DateTimeZone.forID( "Asia/Kolkata" );
        DateTime dateTimeZ = new DateTime(timeZone);

        System.out.println(dateTimeZ.toString(pattern));

        System.out.println(dateTime.toString(pattern));
        System.out.println(dateTime.toString(pattern, Locale.GERMANY));
        System.out.println(dateTime.toString(pattern, Locale.FRENCH));
        System.out.println(dateTime.toString(pattern, Locale.JAPANESE));
    }
}
