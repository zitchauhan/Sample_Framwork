package javautils;

public class StringUtils {

	private StringUtils() {
		// Private constructor to prevent instantiation
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static String capitalizeFirstLetter(String str) {
		if (isEmpty(str)) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	public static String reverse(String str) {
		if (isEmpty(str)) {
			return str;
		}
		return new StringBuilder(str).reverse().toString();
	}
}
