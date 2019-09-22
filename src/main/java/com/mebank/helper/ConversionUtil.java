package com.mebank.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConversionUtil {

    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

    /**
     * Convert date string in format of  "DD/MM/YYYY hh:mm:ss" to LocalDateTime instance
     * @param dateString
     * @return
     */
    public static Date stringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            //TODO add log
            return null;
        }
    }
}
