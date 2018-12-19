package Lesson8HW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoundingFibonacci {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		long[] fibonacci = new long[46];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		for (int i = 3; i < 46; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		for (int i = 0; i < 5; i++) {
			int value = readInt();
			int valuePlace = Arrays.binarySearch(fibonacci, value);
			if (valuePlace > 0) {
				System.out.println(value);
			} else {
				int maxValue = -valuePlace - 1;
				int minValue = -valuePlace - 2;
				if (fibonacci[maxValue] - value > value - fibonacci[minValue]) {
					System.out.println(fibonacci[minValue]);
				} else {
					System.out.println(fibonacci[maxValue]);
				}
			}
		}
	}
	
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
