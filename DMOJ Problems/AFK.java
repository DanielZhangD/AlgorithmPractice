package Lesson5HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AFK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException{
		int t = readInt();
		for (int cases = 0; cases < t; cases++) {
			int l = readInt();
			int w = readInt();
			int xComp = 0;
			int yComp = 0;
			char[][] map = new char[l][w];
			for (int i = 0; i < w; i++) {
				String line = next();
				char[] lineChar = line.toCharArray();
				for (int j = 0; j < l; j++) {
					map[j][i] = lineChar[j];
					if (map[j][i]  == 'C') {
						xComp = j;
						yComp = i;
					}
				}
			}
			/*
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			*/
			//System.out.println("adding complete");
			Queue<Integer> xPosition = new LinkedList<Integer>();
			Queue<Integer> yPosition = new LinkedList<Integer>();
			int[][] distance = new int[l][w];
			boolean[][] visited = new boolean[l][w];
			xPosition.add(xComp);
			yPosition.add(yComp);
			visited[xComp][yComp] = true;
			boolean complete = false;
			while (!complete && !xPosition.isEmpty()) {
				int xNew = (int) xPosition.poll();
				int yNew = (int) yPosition.poll();
				//System.out.println(xNew + " " + yNew + " " + distance[xNew][yNew]);
				try {
					if (!visited[xNew - 1][yNew] && map[xNew - 1][yNew] != 'X') {
						visited[xNew - 1][yNew] = true;
						if (map[xNew - 1][yNew] == 'O') {
							distance[xNew - 1][yNew] = distance[xNew][yNew] + 1;
							xPosition.add(xNew - 1);
							yPosition.add(yNew);
						} else if (map[xNew - 1][yNew] == 'W') {
							int wDistance = distance[xNew][yNew] + 1;
							if (wDistance >= 60) {
								System.out.println("#notworth");
							} else {
								System.out.println(wDistance);
							}
							complete = true;
							break;
						}
					}
				} catch(Exception e) {}
				
				try {
					if (!visited[xNew][yNew - 1] && map[xNew][yNew - 1] != 'X') {
						visited[xNew][yNew - 1] = true;
						if (map[xNew][yNew - 1] == 'O') {
							distance[xNew][yNew - 1] = distance[xNew][yNew] + 1;
							xPosition.add(xNew);
							yPosition.add(yNew - 1);
						} else if (map[xNew][yNew - 1] == 'W') {
							int wDistance = distance[xNew][yNew] + 1;
							if (wDistance >= 60) {
								System.out.println("#notworth");
							} else {
								System.out.println(wDistance);
							}
							complete = true;
							break;
						}
					}
				} catch(Exception e) {}
				
				try {
					if (!visited[xNew + 1][yNew] && map[xNew + 1][yNew] != 'X') {
						visited[xNew + 1][yNew] = true;
						if (map[xNew + 1][yNew] == 'O') {
							distance[xNew + 1][yNew] = distance[xNew][yNew] + 1;
							xPosition.add(xNew + 1);
							yPosition.add(yNew);
						} else if (map[xNew + 1][yNew] == 'W') {
							int wDistance = distance[xNew][yNew] + 1;
							if (wDistance >= 60) {
								System.out.println("#notworth");
							} else {
								System.out.println(wDistance);
							}
							complete = true;
							break;
						}
					}
				} catch(Exception e) {}
				
				try {
					if (!visited[xNew][yNew + 1] && map[xNew][yNew + 1] != 'X') {
						visited[xNew][yNew + 1] = true;
						if (map[xNew][yNew + 1] == 'O') {
							distance[xNew][yNew + 1] = distance[xNew][yNew] + 1;
							xPosition.add(xNew);
							yPosition.add(yNew + 1);
						} else if (map[xNew][yNew + 1] == 'W') {
							int wDistance = distance[xNew][yNew] + 1;
							if (wDistance >= 60) {
								System.out.println("#notworth");
							} else {
								System.out.println(wDistance);
							}
							complete = true;
							break;
						}
					}
				} catch(Exception e) {}
			}
			if (!complete) {
				System.out.println("#notworth");
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
