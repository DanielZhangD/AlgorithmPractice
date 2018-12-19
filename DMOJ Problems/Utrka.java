package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Utrka {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int contestants = readInt();
		HashMap<String, Integer> nameLap = new HashMap<String, Integer>();
		for (int i = 0; i < contestants * 2 - 1; i++) {
			String name = next();
			if (!nameLap.containsKey(name)) {
				nameLap.put(name, 1);
			} else {
				nameLap.remove(name);
			}
		}
		String firstKey = nameLap.keySet().stream().findFirst().get();
		System.out.println(firstKey);
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
