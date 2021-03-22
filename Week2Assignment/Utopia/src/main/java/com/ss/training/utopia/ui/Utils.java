/**
 * 
 */
package com.ss.training.utopia.ui;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author derrianharris
 *
 */
public class Utils<T> {

	public static String FormatOptions(List<String> options) {
		return FormatOptions(options.toArray(String[]::new));
	}

	public static String FormatOptions(String... options) {
		String result = "";
		int count = 1;
		for (String s : options) {
			result += (count++) + ") " + s + "\n";
		}
		return result;
	}

	public static String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

	public static String getInput(Boolean caseSen, Integer... expectation) {
		return getInput(caseSen, Arrays.stream(expectation)
				.map(n -> n.toString()).toArray(String[]::new));
	}

	public static String getInput(Boolean caseSen, List<String> expectation) {

		return getInput(caseSen, expectation.toArray(String[]::new));
	}

	public static String getInput(Boolean caseSen, String... expectation) {
		boolean validInput = false;
		Scanner scanner = new Scanner(System.in);
		String input = null;
		while (!validInput) {

			try {
				input = scanner.next();
				if (!caseSen) {
					input = input.toLowerCase();
					expectation = Arrays.stream(expectation)
							.map(n -> n.toLowerCase()).toArray(String[]::new);
				}
				if (Arrays.stream(expectation).anyMatch(input::equals)) {
					validInput = true;
				} else {
					System.out.println("Invalid Input. Try again.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// scanner.close();
		return input;
	}

	public static String getInputRange(int min, int max) {

		if (min > max) {
			return null;
		}
		int count = 1 + max - min;
		Integer[] expectation = new Integer[count];
		for (int i = 0; i < count; i++) {
			expectation[i] = min + i;
		}

		return getInput(false, Arrays.stream(expectation).map(n -> n.toString())
				.toArray(String[]::new));
	}

	public static String getPassInput() {
		Console console = System.console();
		String password = "";
		if (console != null) {
			String.valueOf(console.readPassword());
		}
		password = getInput();

		// return Hash(password);
		return password;
	}

	public static String Hash(String string) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			byte[] hashedPassword = md
					.digest(string.getBytes(StandardCharsets.UTF_8));
			return new String(hashedPassword, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error hashing password");
			e.printStackTrace();
		}
		return "";
	}

}
