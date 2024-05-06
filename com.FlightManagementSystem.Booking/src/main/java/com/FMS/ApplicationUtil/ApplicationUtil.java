package com.FMS.ApplicationUtil;

import java.util.Random;

public class ApplicationUtil {
	
	
	
	public static String generatePNR() {
		String prefix = generateRandomLetters(2);
		int number = generateRandomNumber(999, 10000);
		String suffix = generateRandomLetters(3);
		return prefix+number+suffix;
	}
	
	
	public static String generateRandomLetters(int num) {
		 Random random = new Random();
	        StringBuilder builder = new StringBuilder();
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alphabet characters
	        for (int i = 0; i < num; i++) {
	            int index = random.nextInt(characters.length());
	            builder.append(characters.charAt(index));
	        }
	        return builder.toString();
	}
	
	public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
	
	
	
	
	//PN2123ABC --> PNR Format

}
