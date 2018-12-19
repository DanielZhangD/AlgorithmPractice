package Lesson5HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PMS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for (int t = 1; t <= T; t++) {
			int n = readInt(), dep = 0, cur = -1;
			String s[] = new String[n];
			HashSet<String> st = new HashSet<String>();
			for (int i = 0; i < n; i++) s[i] = readLine();
			for (int i = n - 1; i >= 0; i--) {
				if (st.contains(s[i])) {
					cur--;
				} else {
					cur++;
					dep = Math.max(dep,  cur);
					st.add(s[i]);
				}
			}
			System.out.println(n * 10 - dep * 20);
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
