package Lesson1HW;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AbsolutelyAcidic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int sensors = readInt();
		int[] sensorArray = new int[1000];
		int maxValue = 0;
		int minValue = 0;
		for (int i = 0; i < sensors; i++) {
			int sensed = readInt();
			sensorArray[sensed - 1]++;
			if (i != 0) {
				if (sensorArray[sensed - 1] >= sensorArray[maxValue]) {
					System.out.println("A");
					if (sensed - 1 > maxValue && sensorArray[sensed - 1] == sensorArray[maxValue]) {
						if (sensorArray[maxValue] > sensorArray[minValue]) {
							minValue = maxValue;
						} else if (Math.abs(sensed - 1 - maxValue) > Math.abs(sensed - 1 - minValue)) {
							minValue = maxValue;
						}
						maxValue = sensed - 1;
					} else if (sensorArray[sensed - 1] > sensorArray[maxValue]) {
						
						if (sensorArray[maxValue] > sensorArray[minValue]) {
							minValue = maxValue;
						} else if (maxValue < minValue) {
							minValue = maxValue;
						}
						maxValue = sensed - 1;
					} else if (sensorArray[sensed - 1] > sensorArray[minValue]) {
						minValue = sensed - 1;
					}
				} else if (sensorArray[sensed - 1] >= sensorArray[minValue]) {
					System.out.println("B");
					if (sensorArray[sensed - 1] > sensorArray[minValue] || sensed - 1 < minValue) {
						minValue = sensed - 1;
					}
				}
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
