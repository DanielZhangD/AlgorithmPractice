package Lesson3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//OR USE LASTINDEXOF
public class Poetry {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static boolean vowelCheck(String characters, String[] vowels) {
		for (int i = 0; i < 5; i++) {
			if (characters.equals(vowels[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		String[] vowels = {"a", "e", "i", "o", "u"};
		int rhymes = readInt();
		for (int i = 0; i < rhymes; i++) {
			String newLine = readLine();
			String[] newLineArray = newLine.split(" ");
			String endA = "notathing";
			String endB = "notathing";
			String endC = "notathing";
			String endD = "notathing";

			for (int j = newLineArray[newLineArray.length - 1].length() - 1; j >= 0; j--) {
				String characters = String.valueOf(newLineArray[newLineArray.length - 1].charAt(j)).toLowerCase();
				if (vowelCheck(characters, vowels)) {
					endA = newLineArray[newLineArray.length - 1].substring(j).toLowerCase();
					break;
				}
			}
			if (endA.equals("notathing")) {
				endA = newLineArray[newLineArray.length - 1];
			}
			newLine = readLine();
			newLineArray = newLine.split(" ");
			
			for (int j = newLineArray[newLineArray.length - 1].length() - 1; j >= 0; j--) {
				//System.out.println(newLineArray[newLineArray.length - 1] + (newLineArray.length - 1) +  newLineArray[newLineArray.length - 1].charAt(j));
				String characters = String.valueOf(newLineArray[newLineArray.length - 1].charAt(j)).toLowerCase();
				if (vowelCheck(characters, vowels)) {
					endB = newLineArray[newLineArray.length - 1].substring(j).toLowerCase();
					break;
				}
			}
			if (endB.equals("notathing")) {
				endB = newLineArray[newLineArray.length - 1];
			}
			newLine = readLine();
			newLineArray = newLine.split(" ");
			
			for (int j = newLineArray[newLineArray.length - 1].length() - 1; j >= 0; j--) {
				String characters = String.valueOf(newLineArray[newLineArray.length - 1].charAt(j)).toLowerCase();
				if (vowelCheck(characters, vowels)) {
					endC = newLineArray[newLineArray.length - 1].substring(j).toLowerCase();
					break;
				}
			}
			if (endC.equals("notathing")) {
				endC = newLineArray[newLineArray.length - 1];
			}
			newLine = readLine();
			newLineArray = newLine.split(" ");
			
			for (int j = newLineArray[newLineArray.length - 1].length() - 1; j >= 0; j--) {
				String characters = String.valueOf(newLineArray[newLineArray.length - 1].charAt(j)).toLowerCase();
				if (vowelCheck(characters, vowels)) {
					endD = newLineArray[newLineArray.length - 1].substring(j).toLowerCase();
					break;
				}
			}
			if (endD.equals("notathing")) {
				endD = newLineArray[newLineArray.length - 1];
			}
			
			//if (i == 3)System.out.println(endA + " " + endB + " " + endC + " " + endD);
			
			if (endA.equals(endD)) {
				if (endA.equals(endB) && endB.equals(endC)) {
					System.out.println("perfect");
				} else if (endB.equals(endC)) {
					System.out.println("shell");
				} else {
					System.out.println("free");
				}
			} else if (endA.equals(endB) && endC.equals(endD)) {
				System.out.println("even");
			} else if (endA.equals(endC) && endB.equals(endD)) {
				System.out.println("cross");
			} else {
				System.out.println("free");
			}
			//System.out.println(endA + " " + endB + " " + endC + " " + endD);
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
