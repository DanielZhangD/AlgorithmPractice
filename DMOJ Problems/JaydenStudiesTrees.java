package Lesson6HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JaydenStudiesTrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static ArrayList<Integer> adj[];
	static int farNode;
	static int[] dis;
	
	public static void main(String[] args) throws IOException{
		int n = readInt();
		adj = new ArrayList[n + 1];
		dis = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			int x = readInt();
			int y = readInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		bfs(1);
		bfs(farNode);
		System.out.println(dis[farNode]);
	}
	
	public static void bfs(int st) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(st);
		boolean[] vis = new boolean[adj.length];
		vis[st] = true;
		dis[st] = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			farNode = u;
			for (int v : adj[u]) {
				if (!vis[v]) {
					queue.add(v);
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
