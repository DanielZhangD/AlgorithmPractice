package Lesson3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewSorting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int n = readInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		int min = 1, max = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if (a[i - 1] == 0 && a[i] == 0) {
				continue;
			}
			if (a[i - 1] != 0 && a[i] == 0) {
				min = Math.max(min,  a[i - 1]);
			} else if (a[i - 1] == 0 && a[i] != 0) {
				max = Math.min(max, a[i]);
			} else if (a[i - 1] > a[i]) {
				System.out.println("NO");
				return;
			}
		}
		if (min <= max) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
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
