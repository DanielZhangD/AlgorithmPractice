package Lesson10HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//BFS
//When someone chases someone, always run a BFS on all members
//Therefore, start with the chasers -> Rabbits.
//Do a BFS with those guys as the start (each "start distance" is 0 for each rabbit)
//Therefore, find the distance from each node (rabbit)
//Now, go from A -> B with for the carrot
//For this to work, make sure to have a previous array, which will let you
//check which nodes you started from
//(previous array has each node with the array value as the previous node)
//i.e.|0|1|2|3|4 (names of each array spot/key)
//|2|-1|3|4|0 -> tells you where the node is connected from, -1 is start point
//From here, look at all values in your path from x to y, and check the distance of each one
//Find the closest distance, and that is the distance from a rabbit on path
public class BadBunnies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
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
