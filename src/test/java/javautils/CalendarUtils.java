package javautils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarUtils {

    // Format for date strings
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Get the current date in the specified format.
     * 
     * @param format the desired format
     * @return the formatted date string
     */
    public static String getCurrentDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * Parse a date string to a Date object.
     * 
     * @param dateString the date string
     * @param format the format of the date string
     * @return the Date object
     * @throws ParseException if the date string cannot be parsed
     */
    public static Date parseDate(String dateString, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }

    /**
     * Add days to the current date.
     * 
     * @param days the number of days to add
     * @return the new date
     */
    public static Date addDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    /**
     * Subtract days from the current date.
     * 
     * @param days the number of days to subtract
     * @return the new date
     */
    public static Date subtractDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        return calendar.getTime();
    }

    /**
     * Get the first day of the month.
     * 
     * @return the first day of the month
     */
    public static Date getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * Get the last day of the month.
     * 
     * @return the last day of the month
     */
    public static Date getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * Convert a Date object to a string in the specified format.
     * 
     * @param date the Date object
     * @param format the desired format
     * @return the formatted date string
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Get the current date and time in a specific format.
     * 
     * @return the formatted date and time string
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * Convert a Date object to UTC time zone.
     * 
     * @param date the Date object
     * @return the UTC formatted date string
     */
    public static String convertToUTC(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    /**
     * Get the difference in days between two dates.
     * 
     * @param start the start date
     * @param end the end date
     * @return the difference in days
     */
    public static long getDifferenceInDays(Date start, Date end) {
        long difference = end.getTime() - start.getTime();
        return difference / (1000 * 60 * 60 * 24);
    }

}
