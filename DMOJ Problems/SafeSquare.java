package Lesson10HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeSquare {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int height = readInt();
		int width = readInt();
		char[][] map = new char[height][width];
		for (int x = 0; x < height; x++) {
			String newLine = readLine();
			for (int y = 0; y < width; y++) {
				map[x][y] = newLine.charAt(y);
			}
		}
		int safe = 0;
		int surroundings = 0;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				for (int i = 0; i < 8; i++) {
					int number = 8;
					try {
						
					}catch (Exception e) {
						number--;
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
