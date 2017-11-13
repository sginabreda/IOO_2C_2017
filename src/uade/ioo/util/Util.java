package uade.ioo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(Exception e) { 
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static boolean isDouble(String s) {
	    try { 
	        Double.parseDouble(s); 
	    } catch(Exception e) { 
	        return false; 
	    } 
	    // only got here if we didn't return false
	    return true;
	}
	
	public static String formatDate(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}
	
	public static Date addDays(Date date, int days){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
}
