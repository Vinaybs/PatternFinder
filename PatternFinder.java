package com.myforum;

import com.myforum.application.exception.CustomDataAccessException;

public class PatternFinder {

	public static void main(String[] args) throws CustomDataAccessException {
		System.out.println(findHighestPattern("aabejiabkfabejiabkkkkkk"));
	}

	public static String findHighestPattern(String inputString) {
		String pattern = "";
		int patternLength = 1;
		for (int i = 0; i < inputString.length(); i++) {
			String stringToCompare = String.valueOf(inputString.charAt(i));
			String restOfTheString = retrieveRestOfTheString(i + 1, inputString);
			if (restOfTheString != null
					&& restOfTheString.contains(stringToCompare)) {
				int localPatternLength = patternLength;
				for (int j = i + 1; j < inputString.length(); j += localPatternLength) {
					String localRestOfTheString = retrieveRestOfTheString(
							j + 1, inputString);
					stringToCompare = stringToCompare.concat(String
							.valueOf(inputString.charAt(j)));
					if (localRestOfTheString != null
							&& localRestOfTheString.contains(stringToCompare)) {
						if (patternLength < stringToCompare.length()) {
							patternLength = stringToCompare.length();
							pattern = stringToCompare;
						}
					}
				}
				if (patternLength == inputString.length() / 2) {
					break;
				}
			}
		}

		return pattern;
	}

	private static String retrieveRestOfTheString(int startIndex,
			String inputString) {
		if (startIndex < inputString.length()) {
			return inputString.substring(startIndex);
		}
		return null;
	}

}
