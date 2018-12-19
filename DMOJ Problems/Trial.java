package Lesson4HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Trial {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int K = readInt(), last = 0 , u[] = new int[5002], v[] = new int[5002], cnt = 0;
		for (int n = 5000; n > 1; n--) {
			while (n * (n - 1) / 2 <= K) {
				int start = last + 1, end = last + n;
				if (last != 0) {
					u[cnt] = last;
					v[cnt] = start;
					cnt++;
				}
				for (int i =  start; i < end; i++) {
					u[cnt] = i;
					v[cnt] = i + 1;
					cnt++;
				}
				u[cnt] = end;
				v[cnt] = start;
				cnt++;
				K -= n * (n - 1) / 2;
				last = end;
			}
		}
		System.out.println(last + " " + cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(u[i] + " " + v[i]);
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
