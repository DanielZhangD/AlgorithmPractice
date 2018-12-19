package Lesson10HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DeathGun {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		//This is a directed graph
		//When we get the values, we make sure to assign a value to each name
		//I.e. in example case: Fatal - 1, Quantum - 2, Etc...
		//Have a string array for this, where each array spot is a name
		//||Fatal|Quantum|...|
		//After this, make sure to record the graph
		//Record in degrees (how many people point at one specific thing
		//Go from the top and go through the people who have 0 indegree
		//pop those people, then have their outdegrees subtract the other indegrees
		//ie whoever gets removed, subtract the indegrees of the ones connected to the removed one by 1
		//If there are people who have 0 indegrees for multiple people, have the people who came first be outputed
		//i.e. |1|2|3|0|0|
		//Have person 4 be removed first
		//Keep on looping through, removing all those with indegree 0 (set their indegree to -1)
		//Do this until all 0's have been popped
		//Make sure to output the names as this occurs
		//This is EXACTLY a topologic sort
		
		int m = readInt();
		int[] in = new int[2 * m]; //(m is # of edges, so we will have AT MOST 2 * m vertices)
		//above is indegrees
		int cnt = 0;
		String[] name = new String[2 * m]; //again, we can have 2 * m names
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//now build an adjacency list
		ArrayList<Integer> adj[] = new ArrayList[2 * m];
		//belw handles the input
		for (int i = 0; i < m; i++) {
			String a = next();
			String b = next();
			if (!map.containsKey(a)) {
				map.put(a, cnt); 
				name[cnt] = a;
				adj[cnt++] = new ArrayList<Integer>();
				//initializes the arrayList at cnt
			}
			if (!map.containsKey(b)) {
				map.put(b, cnt); 
				name[cnt] = b;
				adj[cnt++] = new ArrayList<Integer>();
			}
			adj[map.get(b)].add(map.get(a));
			in[map.get(a)]++;
		}
		//cnt is the iterator for the name
		
		//Topologic sort
		while(true) {
			int id = -1;
			for (int i = 0; i < cnt; i++) {
				if (in[i] == 0) {//finding a value with indegree 0
					in[i]--;//set that indegree to -1
					id = i;//change the id, or our current vertex, to that value
					break;
				}
			}
			if (id == -1) {//if none of the vertices have indegree 0, we kill the loop
				break;
			}
			System.out.println(name[id]);//this is when the id was successfully changed, so we print the name
			for (int v : adj[id]) {//Here, we look at each connection that spawned from 
				in[v]--;//the id, and we reduce the indegrees by 1
			}
		}
		//cnt, the count, constantly goes up each tim
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
