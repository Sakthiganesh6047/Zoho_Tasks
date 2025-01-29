package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;

public class TimeUtil {

    public static String getCurrentTimeWithDate(String format) throws CustomException {
    	try {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return currentTime.format(formatter);
    	} catch(Exception e) {
    		throw new CustomException("Error occured in getting Current time with date." , e);
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

    public static String getCurrentTimeInZone(String zoneId , String format) throws CustomException {
    	try {
	        ZonedDateTime zoneTime = ZonedDateTime.now(ZoneId.of(zoneId));
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	        return zoneTime.format(formatter); 
    	} catch(Exception e) {
    		throw new CustomException("Error while getting time in " + zoneId , e);
    	}
    }

    public static String getWeekdayFromMillis(long millis , String zone) throws CustomException {
    	UtilValidator.isNull(millis);
    	try {
    		ZoneId zoneId = ZoneId.of(zone);
	        LocalDate date = Instant.ofEpochMilli(millis).atZone(zoneId).toLocalDate();
	        return date.getDayOfWeek().toString();
    	} catch(Exception e) {
    		throw new CustomException("Error in getting weekday" , e);
    	}
    }

    public static String getMonthFromMillis(long millis , String zone) throws CustomException {
    	UtilValidator.isNull(millis);
    	try {
    		ZoneId zoneId = ZoneId.of(zone);
	        LocalDate date = Instant.ofEpochMilli(millis).atZone(zoneId).toLocalDate();
	        return date.getMonth().toString();
    	} catch (Exception e) {
    		throw new CustomException("Error in getting month" , e);
    	}
    }

    public static int getYearFromMillis(long millis , String zone) throws CustomException {
    	UtilValidator.isNull(millis);
    	try {
    		ZoneId zoneId = ZoneId.of(zone);
	        LocalDate date = Instant.ofEpochMilli(millis).atZone(zoneId).toLocalDate();
	        return date.getYear();
    	} catch(Exception e) {
    		throw new CustomException("Error in getting year from millis" , e);
    	}
    }
    
    public static String getOffsetForZoneID(String zoneIdInput , String dateInput) {
    	ZoneId zoneId = ZoneId.of(zoneIdInput);
    	LocalDate date = LocalDate.parse(dateInput);
    	LocalDateTime dateTime = date.atStartOfDay();
        ZonedDateTime zonedDateTime = dateTime.atZone(zoneId);
        ZoneOffset offset = zonedDateTime.getOffset();
        return offset.toString();
    }
}

