package com.springapp.mvc.services.time;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Hours;
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


        DateTimeFormatter formatter = DateTimeFormat.forPattern("ddMMYYYY HH:mm");
        DateTime date = formatter.withZone(DateTimeZone.forOffsetHours(5)).parseDateTime("17022015 23:53");
        System.out.println(Hours.hoursBetween(date, new DateTime()).getHours());

    }
}
