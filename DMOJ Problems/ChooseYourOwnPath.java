package Lesson4HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ChooseYourOwnPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int pages = readInt();
		ArrayList[] pageList = new ArrayList[pages + 1];
		int complete = 0;
		for (int i = 1; i <= pages; i++) {
			pageList[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= pages; i++) {
			int options = readInt();
			if (options == 0) {
				pageList[i].add(0);
			}
			for (int j = 0; j < options; j++) {
				int path = readInt();
				pageList[i].add(path);
			}
		}
		
		/*for (int i = 1; i <= pages; i++) {
			for (int j = 0; j < pageList[i].size(); j++) {
				System.out.print(pageList[i].get(j) + " ");
			}
			System.out.println("");
		}*/
		
		
		boolean exist[] = new boolean[pages + 1];
		for (int i = 0; i < pages + 1; i++) {
			exist[i] = false;
		}
		Queue<Integer> pageQueue = new LinkedList<Integer>();
		pageQueue.add(1);
		int lowestDistance = Integer.MAX_VALUE;
		int currentDistance = 2;

		int connected = pageList[1].size() + 1;
		int nextSize = 0;
		while(pageQueue.peek() != null) {
			int queueFirst = pageQueue.poll();
			//System.out.println(queueFirst);
			
			exist[queueFirst] = true;
			//System.out.println("queueFirst at " + queueFirst + " " + exist[queueFirst]);
			//System.out.println("Connected is " + connected);
			if (connected == 0) {
				//System.out.println("YOSH");
				//if (queueFirst == 1) {
				//	currentDistance -= 2;
				//}
				currentDistance++;
				connected = nextSize + 1;
				nextSize = 0;
			} else if (queueFirst != 1) {
				//System.out.println("NextSize is !" + nextSize);
				nextSize += pageList[queueFirst].size();
					//System.out.println("NextSize is !!" + nextSize);
			}

			
			for (int i = 0; i < pageList[queueFirst].size(); i++) {
				
				if (!exist[(int) pageList[queueFirst].get(i)]) {
					//System.out.println(pageList[queueFirst].get(i));
					//System.out.println("pageList at queueFirst is " + pageList[queueFirst].get(i));
					//System.out.println(exist[(int) pageList[queueFirst].get(i)]);
					//System.out.println(pageList[queueFirst].get(i) + "current value " + queueFirst);
					if ((int)pageList[queueFirst].get(i) != 0) {
						//System.out.println("HELLO!");
						pageQueue.add((int) pageList[queueFirst].get(i));
					} else {
						//System.out.println("HI!");
						if (currentDistance < lowestDistance) {
							lowestDistance = currentDistance;
							if (queueFirst == 1) {
								lowestDistance = 1;
							}
						}
					}
				}
			}
			connected--;
		}
		boolean doesIt = true;
		for (int i = 1; i < pages + 1; i++) {
			//System.out.println(i + " " + exist[i]);
			if (!exist[i]) {
				System.out.println("N");
				doesIt = false;
				break;
			}
		}
		if (doesIt) {
			System.out.println("Y");
		}
		System.out.println(lowestDistance);
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
