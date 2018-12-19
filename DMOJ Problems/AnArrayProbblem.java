package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AnArrayProbblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		long n = readLong();
		long[] array = new long[(int) n];
		long successes = 0;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			sum += array[i];
		}
		Arrays.sort(array);
		long successes1 = (long)(Math.floor(sum / 2));
		long successes2 = (long)(sum - array[(int) (n - 1)]);
		//System.out.println(successes1 + " add " + successes2);
		successes = Math.min(successes1, successes2);
		if (n == 1) {
			successes = 0;
		}
		System.out.println(successes);
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
