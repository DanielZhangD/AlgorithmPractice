package Lesson5HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class RunningInCircles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static int cycleFinder() throws IOException {
		ArrayList[] nodeList = new ArrayList[101];
		int[] nodeActivation = new int[101];
		for (int i = 1; i < 101; i++) {
			nodeList[i] = new ArrayList<Integer>();
		}
		
		Stack<Integer> nodeStack = new Stack<Integer>();
		int distance = 1;
		int paths = readInt();
		
		int[] nodeDistance = new int[101];
		
		for (int i = 0; i < paths; i++) {
			int start = readInt();
			int end = readInt();
			nodeList[start].add(end);
		}
		nodeStack.push(1);
		nodeStack.push((Integer) nodeList[1].get(0));
		nodeActivation[1] = 1;
		nodeDistance[1] = 1;
		while (!nodeStack.empty()) {
			int nextPath = nodeStack.pop();
			nodeDistance[nextPath] = ++distance;
			for (int i = 0; i < nodeList[nextPath].size(); i++) {
				if (nodeActivation[(int)nodeList[nextPath].get(i)] == 2 && i != nodeList[nextPath].size() - 1) {
					//System.out.println("Hi");
					continue;
				} else if (nodeActivation[(int)nodeList[nextPath].get(i)] == 0) {
					nodeStack.push(nextPath);
					nodeStack.push((Integer) nodeList[nextPath].get(i));
					nodeActivation[nextPath] = 1;
					//distance++;
					//System.out.println("heya");
					break;
				} else if (nodeActivation[(int)nodeList[nextPath].get(i)] == 1) {
					//System.out.println("HELLO!" + (int)nodeList[nextPath].get(i) + " " + nextPath);
					//System.out.println(nodeDistance[nextPath]);
					int cycleDistance = Math.abs(nodeDistance[nextPath] - nodeDistance[(int)nodeList[nextPath].get(i)]) + 1;
					return cycleDistance;
				} else if (nodeActivation[(int)nodeList[nextPath].get(i)] == 2 && i == nodeList[nextPath].size() - 1) {
					nodeActivation[nextPath] = 2;
					//System.out.println("noa");
					distance -= 2;
				}
			}
			if (nodeList[nextPath].size() == 0) {
				nodeActivation[nextPath] = 2;
			}
			//System.out.println("HII!" + nextPath + " distance " + distance);
			//System.out.println(Arrays.toString(nodeStack.toArray()));
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException{
		
		for (int cases = 0; cases < 5; cases++) {
			System.out.println(cycleFinder());
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
