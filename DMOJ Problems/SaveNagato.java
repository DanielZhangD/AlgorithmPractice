package Lesson7HW;
//This is... a weighted tree
//What should we do?
//Dp a bfs from every node, once again, and add each value from there to get the distances
//After getting the farthest node, you get the diameter
//From there, you can travel backwards from furthest node and find the distance from each point
//Again, after finding the other end of the diameter, do another BFS and find the diameter again
//from there, find the longest and second longest for each one
//therefore, you can have the second longest path (i.e. from 1 to 7 is second longest, and from 8 to 2)
//However, you can find that there is a second longest path with the same length and longest path
//Basically, do a BFS/DFS 3 times
//How do you add weights to the edges?
//to do this, you have an adjacency list... but you need to store two values into each one, so you need
//to use an adjacency list of classes

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SaveNagato {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, far;
	static int len, ans;
	//len is longest length
	//far is farthest length
	static ArrayList<Integer> adj[];
	
	public static void main(String[] args) throws IOException{
		n = readInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			//u is initial point
			//v is end vertex
			//w is edge weight
			int u = readInt();
			int v = readInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		int[] dis1 = new int[n + 1];
		int[] dis2 = new int[n + 1];
		bfs(1, dis1); 
		int p1 = far; bfs(p1, dis1); 
		int p2 = far; bfs(p2, dis2);
		for (int i = 1; i <= n; i++) {
			System.out.println(Math.max(dis1[i], dis2[i]) + 1);
		}
	}
	
	public static void bfs(int st, int[] dis) {
		boolean [] vis = new boolean[n + 1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(st);
		vis[st] = true;
		dis[st] = 0;
		len = 0;
		//st is start point
		while (!Q.isEmpty()) {
			int u = Q.poll();
			if (dis[u] > len) {
				len = dis[u];
				far = u;
			}
			for (int v: adj[u]) {
				if (!vis[v]) {
					Q.add(v);
					vis[v] = true;
					dis[v] = dis[u] + 1;
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
