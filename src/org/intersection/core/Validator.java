package org.intersection.core;

/**
 * Class that validates the user input
 * @author akubatoor
 *
 */
public class Validator {

	static boolean validateDouble(String input) {
		try {
			Double.parseDouble(input);
		} catch(NumberFormatException nfe){
			System.out.println("Invalid input");
			return false;
		}
		return true;
	}

	static boolean validatePoints(String[] point,int i) {
		if(point.length != (i*2)) {
			System.out.println("Incomplete input");
			return false;
		}
		try{
			for(String value : point){
				Double.parseDouble(value);
			}
		} catch(NumberFormatException nfe){
			System.out.println("Invalid input");
			return false;
		}	
		return true;
	}

}
