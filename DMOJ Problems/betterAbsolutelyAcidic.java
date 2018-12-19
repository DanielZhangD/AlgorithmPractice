package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class betterAbsolutelyAcidic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int sensors = readInt();
		int[] sensorArray = new int[1000];
		int maxValue = 0;
		int minValue = 0;
		ArrayList<Integer> maxValueA = new ArrayList<Integer>();
		ArrayList<Integer> minValueA = new ArrayList<Integer>();
		for (int i = 0; i < sensors; i++) {
			int sensed = readInt();
			sensorArray[sensed - 1]++;
			if (i != 0) {
				
			} else {
				System.out.println("1 activated");
				maxValue = sensed - 1;
				minValue = sensed - 1;
			}
		}
		System.out.println(minValue + " " + maxValue);
		System.out.println(Math.abs(maxValue - minValue));
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
