package Lesson6HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class diameter {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	//to find the diameter of a tree
	//run a BFS from any node, get the farthest node
	//Do another BFS with the farthest node, the final distance value is the Diameter
	//once you find your starting far node and ending far node, you will know that, for each node in the tree
	//the max distance will be to one of the above nodes
	//DIAMETER PROPERTIES
	//1) The max distance to any node in the tree is one of the diameter end points
	//2) Center of the tree >> where, if you take center as root of tree, depth of other nodes is minimized
	//This center node is ALWAYS on the path of the diameter
	//maximum of 2 center of trees
	//HOWEVER, when there is a Weighted Tree, life isn't so simple
	//minimum path is radius
	
	public static void main(String[] args) throws IOException{
		
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
