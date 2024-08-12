package javautils;

import java.io.*;

public class FileUtils {

	private FileUtils() {
		// Private constructor to prevent instantiation
	}

	public static void writeToFile(String filePath, String content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(content);
		}
	}

	public static String readFile(String filePath) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append(System.lineSeparator());
			}
		}
		return content.toString().trim();
	}

	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);
		return file.delete();
	}
}
