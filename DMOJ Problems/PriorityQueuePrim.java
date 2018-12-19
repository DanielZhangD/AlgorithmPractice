package Lesson10HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//THIS TAKES LOG(N) TIME

//We add a priority queue to your regular PrimAlgorithm
//When you find that there is a distance that is better then before
//add it to the prioity queue
//So, for example, with our initial graph
//when we select and update A, we make a priotiy queue, which then gives us
//|38,B|46.C|19,F|
//Now, prioity queue gives to top value, which is 19, F
//Then, update and select F, giving us an updated priority Queue
//|38,B|46,C|25,C|25,D|26,F|
//25, C will be updated. and then we insert the next
//|38,B|46,C|25,D|26,D|26,E|

public class PriorityQueuePrim {

	//we can speed this up through a priority queue
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//NOTE, THIS IS SIMILAR TO THE BASIC WAY OF DJIKSTRA
	
	public static void main(String[] args) throws IOException{
		int n = readInt(); //vertices
		int m = readInt(); //edges
		int dis[] = new int[n + 1];
		boolean vis[] = new boolean[n + 1];
		ArrayList<edge> adj[] = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<edge>();
		}//initializing arrayList of edges
		for (int i = 1; i <= m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new edge(v, w));
			adj[v].add(new edge(u, w));
		}//adding the edges to the adjacency list
		Arrays.fill(dis, Integer.MAX_VALUE); // sets all values to max;
		dis[1] = 0; // chooses first node, start point is 0
		//this is where prims algorithm really happens
		for (int i = 1; i <= n; i++) { //loop to n rounds, and each round, see if the dis is less then min
			//and not visited
			//each round adds ONE node to the tree
			//first step is select
			int min = Integer.MAX_VALUE, id = -1;
			//THIS IS THE SELECT LOOP
			for (int j = 1; j <= n; j++) {
				if (!vis[j] && dis[j] < min) {
					//if the vertex here has not been visited and the distance here is less then
					//the minimum distance
					min = dis[j];
					//updates minimum value if this is true
					id = j;
					//updates current id
				}
			}
			vis[id] = true;
			//this loop goes through the values and updates
			//UPDATE LOOP
			//Now, pick through all of it. 
			//If its not updated, and the distance is GREATER than the value in A, change it
			
			for (edge e : adj[id]) {
				if (!vis[e.v] && dis[e.v] > e.w) {
					dis[e.v] = e.w;
				}
			}
		}
		for (int i = 1;  i<= n; i++) {
			System.out.print(dis[i] + " ");
		}
	}
	//this is the constructor to create edges (where it has a connector, and a cost)
	public static class edge {
		int v, w;
		edge(int v0, int w0) {
			v = v0;
			w = w0;
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
