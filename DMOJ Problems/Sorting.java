package Lesson3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sorting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int arrayLength = readInt();
		int[] arr = new int[arrayLength];
		int wildCardLast = -99;
		int lastNumericValue = -99;
		boolean success = true;
		boolean checkFirst = false;
		for (int i = 0; i < arrayLength; i++) {
			arr[i] = readInt();
			if (arr[i] == 0) {
				if (i != 0 && arr[i - 1] != 0) {
					if (wildCardLast == -99 && i != 0 && arr[i - 1] != 0) {
						checkFirst = true;
					} else {
						if (arr[i - 1] > wildCardLast) {
							success = false;
							System.out.println("NO");
							break;
						}
					}
				}
			} else {
				if (lastNumericValue == -99) {
					lastNumericValue = arr[i];
				} else {
					if (arr[i] < lastNumericValue) {
						System.out.println("NO");
						success = false;
						break;
					} else {
						lastNumericValue = arr[i];
					}
				}
				if (checkFirst && arr[i - 1] == 0) {
					wildCardLast = arr[i];
					checkFirst = false;
				}
			}
		}
		if (success) {
			System.out.println("YES");
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
