package Lesson5HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int cases = readInt();
		for (int iteration = 0; iteration < cases; iteration++) {
			int r = readInt();
			int c = readInt();
			char[][] map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String temp = next();
				for (int j = 0; j < c; j++) {
					map[j][i] = temp.charAt(j); 
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0 ; j < c; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
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
