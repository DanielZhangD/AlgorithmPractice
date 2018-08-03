package Lesson_4_HW;

import java.util.*;
import java.io.*;

public class MimiAndBinary{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String line = next();
		int iterations = readInt();
		for (int i = 0; i < iterations; i++) {
			int xIndex = readInt() - 1;
			int finalIndex = 0;
			int yOccurence = readInt();
			int found = 0;
			String xCharacter = next();
			for (int j = 0; j < yOccurence; j++) {
				found = line.indexOf(xCharacter, xIndex);
				//System.out.println(xCharacter + found);
				if (found > -1) {
					//System.out.println("current: " + xIndex);
					xIndex = found + 1;
					//System.out.println("new" + (xIndex));
				} else {
					System.out.println("-1");
					break;
				}
				//System.out.println("end");
			}
			if (found != -1) {
				finalIndex = found;
				System.out.println(finalIndex + 1);
			}
			//System.out.println("");
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