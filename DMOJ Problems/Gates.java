package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gates {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int gNumber = readInt();
		int pNumber = readInt();
		int[] gates = new int[gNumber];
		
		for (int i = 0; i < pNumber; i++) {
			int planeGate = readInt();
			if (gates[planeGate - 1] == 0) {
				gates[planeGate - 1] = 1;
			} else {
				int success = 0;
				for (int j = planeGate - 2; j >=0; j--) {
					if (gates[j] == 0) {
						gates[j] = 1;
						success = 1;
						break;
					}
				}
				if (success == 0) {
					System.out.println(i);
					break;
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
