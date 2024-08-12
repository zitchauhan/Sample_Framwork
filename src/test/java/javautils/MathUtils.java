package javautils;

public class MathUtils {

	private MathUtils() {
		// Private constructor to prevent instantiation
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
