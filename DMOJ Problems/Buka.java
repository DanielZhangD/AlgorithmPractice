package Lesson4HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Buka {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		String a = next();
		String operand = next();
		String b = next();
		if (operand.equals("*")) {
			int totalLength = a.length() + b.length() - 2;
			System.out.print("1");
			for (int i = 0; i < totalLength; i++) {
				System.out.print("0");
			}
		} else {
			int lengthA = a.length();
			int lengthB = b.length();
			if (lengthA > lengthB) {
				System.out.print("1");
				for (int i = 0; i < lengthA - 1; i++) {
					if (i != Math.abs(lengthA - lengthB - 1)) {
						System.out.print("0");
					} else {
						System.out.print("1");
					}
				}
			} else if (lengthA == lengthB) {
				System.out.print("2");
				for (int i = 0; i < lengthA - 1; i++) {
					System.out.print("0");
				}
			} else {
				System.out.print("1");
				for (int i = 0; i < lengthB - 1; i++) {
					if (i != Math.abs(lengthB - lengthA - 1)) {
						System.out.print("0");
					} else {
						System.out.print("1");
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
