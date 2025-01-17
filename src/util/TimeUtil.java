package util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static String getCurrentTimeWithDate() throws CustomException {
    	try {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
    	} catch(Exception e) {
    		throw new CustomException("Error occured in while getting" , e);
    	}
    }

    public static long getCurrentTimeInMillis() throws CustomException {
    	try {
    		return Instant.now().toEpochMilli();		//using local date and time
    	} catch(Exception e) {
    		throw new CustomException("Error occured while getting time in Millis" , e);
    	}
    }

    public static long getCurrentTimeInMillisUsingSystem() throws CustomException {
    	try {
    		return System.currentTimeMillis();			//using system class
    	} catch(Exception e) {
    		throw new CustomException("Error occured while getting time in millis using system." , e);
    	}
    }

    public static String getCurrentTimeInNewYork() throws CustomException {
    	try {
	        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
	        return newYorkTime.format(formatter); 
    	} catch(Exception e) {
    		throw new CustomException("Error while getting time in New York" , e);
    	}
    }
    
    public static String getCurrentTimeInLondon() throws CustomException {
    	try {
    	ZonedDateTime londonTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
    	return londonTime.format(formatter);
    	} catch(Exception e) {
    		throw new CustomException("Error in getting time in london" , e);
    	}
    }

    public static String getWeekdayFromMillis(long millis) throws CustomException {
    	UtilValidator.isNull(millis);
    	try {
	        LocalDate date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
	        return date.getDayOfWeek().toString();
    	} catch(Exception e) {
    		throw new CustomException("Error in getting weekday" , e);
    	}
    }

    public static String getMonthFromMillis(long millis) throws CustomException {
    	UtilValidator.isNull(millis);
    	try {
	        LocalDate date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
	        return date.getMonth().toString();
    	} catch (Exception e) {
    		throw new CustomException("Error in getting month" , e);
    	}
    }

    public static int getYearFromMillis(long millis) throws CustomException {
    	UtilValidator.isNull(millis);
    	try {
	        LocalDate date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
	        return date.getYear();
    	} catch(Exception e) {
    		throw new CustomException("Error in getting year from millis" , e);
    	}
    }
}

