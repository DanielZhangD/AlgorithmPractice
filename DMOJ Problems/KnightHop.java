package Lesson7HW;
//Do a brute force search
//i.e do a bfs (breadth first search)
//Start from the point
//See where you can go next
//Continue recording these points as you go on, eventually you will reach end point
//end point will have a depth, record it
//MAKE SURE THAT YOU HAVE A VISITED ARRAY, SO THAT IF A PLACE HAS BEEN VISITED, IT WILL NOT BE AGAIN
//otherwise, an infinite loop occurs
//Start with your original point
//Have 2 queues, one for x, one for y
//queue of arrays
//etc.
//Continuously go through this add values in order, constantly adding distance
//Distance array - do current distance + 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightHop {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		//we will start by reading start point x y and end point x y
		int x1 = readInt() - 1, y1 = readInt() - 1;
		int x2 = readInt() - 1, y2 = readInt() - 1;
		//input complete, start the bfs
		int[][] dis = new int[8][8]; //(8 by 8 board)
		boolean[][] vis = new boolean[8][8];// boolean visited array
		Queue<Integer> qx = new LinkedList<Integer>(), qy = new LinkedList<Integer>();
		//above is queues for x value and y values
		qx.add(x1);
		qy.add(y1);
		vis[x1][y1] = true;
		dis[x1][y1] = 0;
		//below is an array that shows each point knight can go (each add)
		int[][] d = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
		//startpoint COMPLETE
		while (!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			for (int k = 0; k < 8; k++) {
				int nx = x + d[k][0], ny = y + d[k][1];
				//gets new x value, new y value
				if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !vis[nx][ny]) {
					//if in bounds, add values
					qx.add(nx);
					qy.add(ny);
					vis[nx][ny] = true;
					dis[nx][ny] = dis[x][y] + 1;
				}
			}
			//iterates through entire thing and gets distance for EACH POINT
		}
		System.out.println(dis[x2][y2]);
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
