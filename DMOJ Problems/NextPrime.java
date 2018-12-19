package Lesson1HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextPrime {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int prime = readInt();
		boolean state = true;
		int smallestPrime = 0;
		if (prime <= 2) {
			System.out.println(2);
		} else {
			if (prime % 2 == 0) {
				prime++;
			}
			if (prime == 3) {
				System.out.println(prime);
			} else if (prime <= 5) {
				System.out.println(5);
			} else if (prime <= 7) {
				System.out.println(7);
			} else if (prime <= 11) {
				System.out.println(11);
			} else {
				while(state) {
					int primeMin = (int)Math.sqrt(prime);
					if (primeMin % 2 == 0) {
						primeMin--;
					}
					for (int i = 3; i <= Math.sqrt(prime); i += 2) {
						//System.out.println("i is" + i);
						//System.out.println(prime % i);
						if (prime % i == 0) {
							break;
						}
						//System.out.println(Math.sqrt(prime));
						if (i >= primeMin) {
							state = false;
							smallestPrime = prime;
							break;
						}
					}
					if (smallestPrime != 0) {
						break;
					}
					prime += 2;
					//System.out.println(prime);
				}
				System.out.println(smallestPrime);
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
