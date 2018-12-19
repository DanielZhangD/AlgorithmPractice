package Lesson4HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IsItATree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int[][] tree = new int[4][4];
		ArrayList[] treeList = new ArrayList[4 + 1];
		for (int i = 1; i <= 4; i++) {
			treeList[i] = new ArrayList<Integer>();
		}
		int branches = 0;
		int knots = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tree[i][j] = readInt();
				if (tree[i][j] == 1) {
					treeList[i + 1].add(j + 1);
					branches++;
				}
			}
		}
		branches = branches / 2;
		for (int i = 1; i <= 4; i++) {
			if (!treeList[i].isEmpty()) {
				knots++;
			}
		}
		if (!(knots == branches + 1)) {
			System.out.println("No");
			return;
		} else {
			System.out.println("Yes");
		}
		boolean[][] treeVisited = new boolean[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tree[i][j] == 1) {
					treeVisited[i][j] = true;
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
