package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeFactorization {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int lines = readInt();
		for (int i = 0; i < lines; i++) {
			int input = readInt();
			if (input == 2) {
				System.out.println(2);
			} else if (input == 1) {
				System.out.println(1);
			} else { 
				if (input % 2 == 0) {
					while (true) {
						if (input % 2 == 0) {
							System.out.print(2 + " ");
							input = input / 2;
						} else {
							break;
						}
					}
				}
				if (input == 1) {
					System.out.println("");
				} else {
					int inputMin = (int)Math.sqrt(input);
					if (inputMin % 2 == 0) {
						inputMin --;
					}
					for (int j = 3; j <= inputMin; j += 2) {
						if (input % j == 0) {
							System.out.print(j + " ");
							input = input / j;
							j = j - 2;
						}
					}
					if (input != 1) {
						System.out.println(input);
					} else {
						System.out.println("");
					}
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
