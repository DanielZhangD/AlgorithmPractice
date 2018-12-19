package Lesson8HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AlexAnimalRights {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int r = readInt();
		int c = readInt();
		char[][] map = new char[r][c];
		int monkeys = 0;
		ArrayList<Integer> monkeyX = new ArrayList<Integer>();
		ArrayList<Integer> monkeyY = new ArrayList<Integer>();
		
		for (int i = 0; i < r; i++) {
			String line = readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				//System.out.print(map[i][j]);
				if (map[i][j] == 'M') {
					monkeys++;
					monkeyX.add(i);
					monkeyY.add(j);
				}
			}
			//System.out.println();
		}
		int drills = 0;
		boolean[][] visited = new boolean[r][c];
		while(!monkeyX.isEmpty()) {
			int x = monkeyX.get(0);
			int y = monkeyY.get(0);
			drills++;
			Queue<Integer> xQueue = new LinkedList<Integer>();
			Queue<Integer> yQueue = new LinkedList<Integer>();
			xQueue.add(x);
			yQueue.add(y);
			visited[x][y] = true;
			while(!xQueue.isEmpty()) {
				int currentX = xQueue.poll();
				int currentY = yQueue.poll();
				if (map[currentX][currentY] == 'M') {
					//System.out.println(currentX + " " +currentY);
					int position = Collections.binarySearch(monkeyX, currentX);
					//System.out.println(position);
					map[currentX][currentY] = '.';
					monkeyX.remove(position);
					monkeyY.remove(position);
				}
				int newX = 0;
				int newY = 0;
				if (currentX > 0) {
					newX = currentX - 1;
					if (map[newX][currentY] != '#' && !visited[newX][currentY]) {
						xQueue.add(newX);
						yQueue.add(currentY);
						visited[newX][currentY] = true;
					}
				
				}
				if (currentY > 0) {
					newY = currentY - 1;
					if (map[currentX][newY] != '#' && !visited[currentX][newY]) {
						xQueue.add(currentX);
						yQueue.add(newY);
						visited[currentX][newY] = true;
					}
				}
				if (currentX < c - 1) {
					newX = currentX + 1;
					if (map[newX][currentY] != '#' && !visited[newX][currentY]) {
						xQueue.add(newX);
						yQueue.add(currentY);
						visited[newX][currentY] = true;
					}
				}
				if (currentY < r - 1) {
					newY = currentY + 1;
					if (map[currentX][newY] != '#' && !visited[currentX][newY]) {
						xQueue.add(currentX);
						yQueue.add(newY);
						visited[currentX][newY] = true;
					}
				}
			}
		}
		System.out.println(drills);
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
