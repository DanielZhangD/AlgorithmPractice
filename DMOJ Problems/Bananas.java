package Lesson3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bananas {
	
	//two cases -> recursion
	//Or, whenever you see a monkeyWord, replace ANA with a
	//Or, replace all B___S with a
	// so ANA -> a, or BAS -> a 
	//If all of it is replaced to be a, then you get solution
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String word = "";
		word = next();
		while (word != "X") {
			while (word.contains("ANA") || word.contains("BAS")) {
				word = word.replace("ANA", "A");
				word = word.replace("BAS", "A");
			}
			if (word.equals("A")) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			word = next();
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
