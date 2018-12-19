package Lesson3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//FIND GCD USING EUCLIDIAN ALGORITHM
//Keep on recursioning with m % n
//continuously do that until m % n = 0;
//where m becomes n and n becomes m % n
//Use recursion

public class MimiAndPrimes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; //USE LONG FOR THIS ONE
	
	public static long gcd(long m, long n) {
		if (n == 0) return m;
		return gcd(n, m % n);
	}
	
	public static void main(String[] args) throws IOException{
		int n = readInt();
		long a[] = new long[n];
		long g = readLong();
		for (int i = 1; i < n; i++) {
			a[i] = readLong();
			g = gcd(g, a[i]);
		}
		if (g == 1) {
			System.out.println("DNE");
			return;
		}
		long ans = 0;
		for (int i = 2; i <= Math.sqrt(g); i++) {
			while (g % i == 0) {
				ans = Math.max(ans,  i);
				g /= i;
			}
		}
		if (g != 1) {
			ans = Math.max(ans, g);
		}
		System.out.println(ans);
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
