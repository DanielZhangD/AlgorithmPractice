package Lesson6HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HeavyLightDecomp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int nodes = readInt();
		int[] weightArray = new int[nodes + 1];
		ArrayList[] nodeConnections = new ArrayList[nodes + 1];
		int queries = readInt();
		for (int i = 1; i <= nodes; i++) {
			weightArray[i] = readInt();
			nodeConnections[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= nodes - 1; i++) {
			int start = readInt();
			int end = readInt();
			nodeConnections[start].add(end);
			nodeConnections[end].add(start);
		}
		for (int iterate = 0; iterate < queries; iterate++) {
			int type = readInt();
			int a = readInt();
			int b = readInt();
			if (type == 1) {
				
			} else if (type == 2) {
				
			} else {
				
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
