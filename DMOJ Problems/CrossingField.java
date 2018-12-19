package Lesson5HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CrossingField {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int size = readInt();
		int height = readInt();
		int[][] map = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = readInt();
			}
		}
		Queue<Integer> xQueue = new LinkedList<Integer>();
		Queue<Integer> yQueue = new LinkedList<Integer>();
		xQueue.add(0);
		boolean[][] mapVisited = new boolean[size][size];
		mapVisited[0][0] = true;
		yQueue.add(0);
		int xNow = 0;
		int yNow = 0;
		while (!xQueue.isEmpty()) {
			
			xNow = xQueue.poll();
			yNow = yQueue.poll();
			//System.out.println(xNow + " " + yNow);
			if (xNow == size - 1 && yNow == size - 1) {
				System.out.println("yes");
				return;
			}
			if (xNow + 1 < size && !mapVisited[xNow + 1][yNow]) {
				//System.out.println("a");
				if (map[xNow + 1][yNow] <= map[xNow][yNow] + height && map[xNow + 1][yNow] >= map[xNow][yNow] - height) {
					//System.out.println("a1");
					xQueue.add(xNow + 1);
					yQueue.add(yNow);
					mapVisited[xNow + 1][yNow] = true;
				}
			}
			if (yNow + 1 < size && !mapVisited[xNow][yNow + 1]) {
				//System.out.println("b");
				if (map[xNow][yNow + 1] <= map[xNow][yNow] + height && map[xNow][yNow + 1] >= map[xNow][yNow] - height) {
					xQueue.add(xNow);
					yQueue.add(yNow + 1);
					mapVisited[xNow][yNow + 1] = true;
				}
			}
			if (yNow - 1 >= 0 && !mapVisited[xNow][yNow - 1]) {
				//System.out.println("c");
				if (map[xNow][yNow - 1] <= map[xNow][yNow] + height && map[xNow][yNow - 1] >= map[xNow][yNow] - height) {
					xQueue.add(xNow);
					yQueue.add(yNow - 1);
					mapVisited[xNow][yNow - 1] = true;
				}
			}
			if (xNow - 1 >= 0 && !mapVisited[xNow - 1][yNow]) {
				//System.out.println("d");
				if (map[xNow - 1][yNow] <= map[xNow][yNow] + height && map[xNow - 1][yNow] >= map[xNow][yNow] - height) {
					xQueue.add(xNow - 1);
					yQueue.add(yNow);
					mapVisited[xNow - 1][yNow] = true;
				}
			}
		}
		System.out.println("no");
		
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
