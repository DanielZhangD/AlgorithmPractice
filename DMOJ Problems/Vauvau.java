package Lesson3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vauvau {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int a = readInt();
		int b = readInt();
		int c = readInt();
		int d = readInt();
		int[] dogA = new int[999];
		int[] dogB = new int[999];
		int counterA = 0;
		int counterB = 0;
		boolean dogAT = true;
		boolean dogBT = true;
		
		for (int i = 0; i < 999; i++) {
			counterA++;
			counterB++;
			
			if (dogAT) {
				dogA[i] = 0;
				if (counterA == a) {
					counterA = 0;
					dogAT = false;
				}
			} else {
				dogA[i] = 1;
				if (counterA == b) {
					counterA = 0;
					dogAT = true;
				}
			}
			
			if (dogBT) {
				dogB[i] = 0;
				if (counterB == c) {
					counterB = 0;
					dogBT = false;
				}
			} else {
				dogB[i] = 1;
				if (counterB == d) {
					counterB = 0;
					dogBT = true;
				}
			}
		}
		
		int p = readInt();
		int m = readInt();
		int g = readInt();
		int death = 0;
		if (dogA[p - 1] == 0) {
			death++;
		}
		if (dogB[p - 1] == 0) {
			death++;
		}
		if (death == 0) {
			System.out.println("none");
		} else if (death == 1) {
			System.out.println("one");
		} else if (death == 2) {
			System.out.println("both");
		}
		
		death = 0;
		if (dogA[m - 1] == 0) {
			death++;
		}
		if (dogB[m - 1] == 0) {
			death++;
		}
		if (death == 0) {
			System.out.println("none");
		} else if (death == 1) {
			System.out.println("one");
		} else if (death == 2) {
			System.out.println("both");
		}
		
		death = 0;
		if (dogA[g - 1] == 0) {
			death++;
		}
		if (dogB[g - 1] == 0) {
			death++;
		}
		if (death == 0) {
			System.out.println("none");
		} else if (death == 1) {
			System.out.println("one");
		} else if (death == 2) {
			System.out.println("both");
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
