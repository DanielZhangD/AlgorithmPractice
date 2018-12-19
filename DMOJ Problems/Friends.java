package Lesson7HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//SINCE EVERY ONE IS ONLY ASSIGNED TO ONE FRIEND... 
//Each person will only have ONE incoming edge connecting them, and one outgoing edge connecting to 
//one other person
//Since everyone only has one friend, you may as well have a linkedlist
//since this simply asks you if the friends like eachother, loop it through and you see if 3 is visited once more
//if its not... end it without any more friends
//This will  always be either a LINKEDLIST or a Loop - no other way

public class Friends {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
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
