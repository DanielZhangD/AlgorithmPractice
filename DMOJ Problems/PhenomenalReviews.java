package Lesson6HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PhenomenalReviews {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	//How do you visit every node and return back?
	//The distance will be 2 * (V - 1), or 2 * E, (2 * # of edges / # vertices - 1)
	//How do you start from a specific node to traverse the tree, and not return to the start node?
	//This is 2 * Edges - depth (longest distance from start node)
	//Start form any node to traverse the tree and do not return to start node
	//2E - diameter
	
	//in this problem, we ust first clean the tree
	//if there is a subtree without a pho restaurant, remove it
	//Start from a pho resataurant
	//Do a dfs, go all the way down to find a DFS
	//When we begin going back... if this child is a pho restaurant, keep
	//else if this retaurant has an adjacencylist with a pho restaurant, keep it
	//Otherwise, remove this subtree/node
	//Go all the way down again.. if child is pho restaurant, keep edge
	//Go all the way down, if x is pho, keep, continue...
	
	static int n, m, dis[], D, farNode, edge;
	//D is diameter
	static ArrayList<Integer> adj[], adj2[];
	static boolean pho[];
	
	public static void main(String[] args) throws IOException{
		int n = readInt();
		m = readInt();
		pho = new boolean[n];
		dis = new int[n];
		adj = new ArrayList[n];
		adj2 = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
			adj2[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i<=m; i++) {
			farNode = readInt();
			pho[farNode] = true;
		}
		for (int i = 1; i < n; i++) {
			int x = readInt();
			int y = readInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		treePruning(farNode, -1);
		dis[farNode] = D = 0;
		dfs(farNode, -1);
		System.out.println(2 * edge - D);
	}
	
	public static void treePruning(int cur, int parent) {
		if (dis[cur] > D) {
			D = dis[cur];
			farNode = cur;
			for (int v: adj[cur]) {
				dis[v] = dis[cur] + 1;
				treePruning(v, cur);
				if (pho[v] || !adj2[v].isEmpty()) {
					adj2[cur].add(v);
					adj2[v].add(cur);
					edge++;
				}
			}
		}
	}
	
	
	public static void dfs(int cur, int par) {
		if (dis[cur] > D) {
			D = dis[cur];
			farNode = cur;
			for (int v: adj2[cur]) {
				if (v != par) {
					dis[v] = dis[cur] + 1; dfs(v, cur);
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
