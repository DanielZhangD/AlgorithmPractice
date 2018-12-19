package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jerseys {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int jerseys = readInt();
		int athletes = readInt();
		int[] jerseyA = new int[jerseys];
		for (int i = 0; i < jerseys; i++) {
			String value = next();
			if (value.equals("S")) {
				jerseyA[i] = 1;
			} else if (value.equals("M")) {
				jerseyA[i] = 2;
			} else if (value.equals("L")) {
				jerseyA[i] = 3;
			}
		}
		int success = 0;
		for (int i = 0; i < athletes; i++) {
			String value = next();
			int size = 0;
			if (value.equals("S")) {
				size = 1;
			} else if (value.equals("M")) {
				size = 2;
			} else if (value.equals("L")) {
				size = 3;
			}
			int number = readInt();
			if (jerseyA[number - 1] >= size) {
				jerseyA[number - 1] = -1;
				success++;
			}
		}
		System.out.println(success);
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
