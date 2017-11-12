package uade.ioo.util;

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
}
