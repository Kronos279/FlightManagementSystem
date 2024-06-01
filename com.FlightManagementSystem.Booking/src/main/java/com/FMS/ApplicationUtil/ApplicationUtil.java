package com.FMS.ApplicationUtil;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationUtil.class);
	
	public static String generatePNR() {
		String prefix = generateRandomLetters(2);
		int number = generateRandomNumber(999, 10000);
		String suffix = generateRandomLetters(3);
		logger.info("Generated PNR "+prefix+number+suffix);
		return prefix+number+suffix;
	}
	
	
	public static String generateRandomLetters(int num) {
		 Random random = new Random();
		 logger.info("Generating Random letters "+num);
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
        int number = random.nextInt(max - min + 1) + min;
        logger.info("Generating Random number "+number);
        return number;
    }
	
	
	
	
	//PN2123ABC --> PNR Format

}
