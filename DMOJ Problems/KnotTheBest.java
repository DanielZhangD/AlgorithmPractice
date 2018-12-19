package Lesson8HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnotTheBest {
	//Dealing with Knots, MWC '15 #4 P4
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int stringNumber = readInt();
		ArrayList[] stringList = new ArrayList[stringNumber + 1];
		for (int i = 1; i <= stringNumber; i++) {
			stringList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < stringNumber; i++) {
			int start = readInt();
			int end = readInt();
			stringList[start].add(end);
		}
		Queue<Integer> stringQueue = new LinkedList<Integer>();
		int first = readInt();
		int last = readInt();
		boolean[] visited = new boolean[stringNumber + 1];
		visited[first] = true;
		stringQueue.add(first);
		while (!stringQueue.isEmpty()) {
			int queueFirst = stringQueue.poll();
			int connection = (int) stringList[queueFirst].get(0);
			if (connection == last) {
				System.out.println("Tangled");
				return;
			}
			if (!visited[connection]) {
				visited[connection] = true;
				stringQueue.add(connection);
			}
		}
		System.out.println("Not Tangled");
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
