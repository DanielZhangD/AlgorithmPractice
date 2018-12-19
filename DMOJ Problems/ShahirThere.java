package Lesson4HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;


public class ShahirThere {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int houses = readInt();
		ArrayList[] houseList = new ArrayList[houses + 1];
		for (int i = 0; i <= houses; i++) {
			houseList[i] = new ArrayList<Integer>();
		}
		int roads = readInt();
		
		int shahirHouse = readInt();
		int dateHouse = readInt();
		if (shahirHouse == dateHouse) {
			System.out.println("GO SHAHIR!");
			return;
		}
		for (int i = 0; i < roads; i++) {
			int roadStart = readInt();
			int roadFinish = readInt();
			houseList[roadStart].add(roadFinish);
			houseList[roadFinish].add(roadStart);
		}
		Queue<Integer> houseQueue = new LinkedList<Integer>();
		houseQueue.add(shahirHouse);
		boolean[] visited = new boolean[houses + 1];
		visited[shahirHouse] = true;
		while(houseQueue.peek() != null) {
			int queueFirst = houseQueue.poll();
			for (int i = 0; i < houseList[queueFirst].size(); i++) {
				if (!visited[(int) houseList[queueFirst].get(i)]) {
					visited[(int) houseList[queueFirst].get(i)] = true;
					houseQueue.add((int) houseList[queueFirst].get(i));
					if ((int)houseList[queueFirst].get(i) == dateHouse) {
						System.out.println("GO SHAHIR!");
						return;
					}
				}
			}
		}
		System.out.println("NO SHAHIR!");
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
