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

public class ThirdPlace {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, far;
	static long len, ans;
	//len is longest length
	//far is farthest length
	static ArrayList<pair> adj[];
	
	public static class pair {
		int v, w;
		//v is end point
		//w is weight
		public pair(int v0,int w0) {
			v = v0;
			w = w0;
		}
	}
	//creates constructor for pair
	
	public static void main(String[] args) throws IOException{
		n = readInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<pair>();
		}
		for (int i = 1; i < n; i++) {
			//u is initial point
			//v is end vertex
			//w is edge weight
			int u = readInt();
			int v = readInt();
			int w = readInt();
			adj[u].add(new pair(v, w));
			adj[v].add(new pair(u, w));
		}
		long [] dis = new long[n + 1];
		bfs(1, dis);
		int p1 = far;
		//this is the first endpoint of diameter
		//do a BFS once more
		bfs(p1, dis);
		len = 0; //reset this
		//Do BFS again, we get the other end of diameter
		int p2 = far;
		//this is the current path
		for  (int i = 1; i <= n; i++) {
			if (i != p2) {
				ans = Math.max(ans,  dis[i]);
			}
		}
		bfs(p2, dis);
		for (int i = 1; i <= n; i++) {
			if (i != p1) {
				ans = Math.max(ans, dis[i]);
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(int st, long[] dis) {
		boolean [] vis = new boolean[n + 1]; len = 0;
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(st);
		vis[st] = true;
		dis[st] = 0;
		//st is start point
		while (!Q.isEmpty()) {
			int u = Q.poll();
			if (dis[u] > len) {
				len = dis[u];
				far = u;
			}
			for (pair e: adj[u]) {
				if (!vis[e.v]) {
					Q.add(e.v);
					vis[e.v] = true;
					dis[e.v] = dis[u] + e.w;
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
