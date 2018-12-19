package Lesson7HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class OrderOfCommands {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int a = -1;
		int b = -1;
		ArrayList<Integer>[] preReqs = new ArrayList[8];
		for (int i = 1; i < 8; i++) {
			preReqs[i] = new ArrayList<Integer>();
		}
		ArrayList<Integer> noPreReq = new ArrayList<Integer>();
		ArrayList<Integer> yesPreReq = new ArrayList<Integer>();
		noPreReq.add(2);
		noPreReq.add(3);
		noPreReq.add(6);
		yesPreReq.add(1);
		yesPreReq.add(4);
		yesPreReq.add(5);
		yesPreReq.add(7);
		preReqs[1].add(2);
		preReqs[4].add(1);
		preReqs[4].add(3);
		preReqs[5].add(3);
		preReqs[7].add(1);
		a = readInt();
		b = readInt();
		while ((a != 0) && (b != 0)) {
			Collections.sort(noPreReq);
			Collections.sort(yesPreReq);
			if (noPreReq.contains(b)) {
				noPreReq.remove(Collections.binarySearch(noPreReq, b));
				yesPreReq.add(b);
			}
			if (!preReqs[b].contains(a)) {
				preReqs[b].add(a);
			}
			a = readInt();
			b = readInt();
		}
		Collections.sort(noPreReq);
		Collections.sort(yesPreReq);
		String line = "";
		for (int i = 1; i <= 7; i++) {
			Collections.sort(preReqs[i]);
		}
		if (noPreReq.isEmpty()) {
			System.out.println("Cannot complete these tasks. Going to bed.");
		} else {
			int completed = 0;
			while (completed != 7) {
				if (noPreReq.isEmpty()) {
					System.out.println("Cannot complete these tasks. Going to bed.");
					break;
				} else {
					int completer = noPreReq.get(0);
					line = line + completer + " ";
					noPreReq.remove(0);
					completed++;
					for (int i = 1; i <= 7; i++) {
						if (preReqs[i].contains(completer)) {
							preReqs[i].remove(Collections.binarySearch(preReqs[i], completer));
							if (preReqs[i].isEmpty()) {
								noPreReq.add(i);
							}
						}
					}
					Collections.sort(noPreReq);
				}
			}
			if (completed == 7) {
				System.out.println(line);
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
