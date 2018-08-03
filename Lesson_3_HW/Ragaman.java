package Lesson_3_HW;

import java.util.Scanner;
import java.util.HashMap;



public class Ragaman {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String initial = input.nextLine();
		String anagram = input.nextLine();
		int differentLettersInitial = 0;
		int differentLettersAnagram = 0;
		int starNumber = 0;
		HashMap<String, Integer> initialMap = new HashMap<String, Integer>();
		HashMap<String, Integer> anagramMap = new HashMap<String, Integer>();
		for (int i = 0; i < initial.length(); i++) {
			int count = initialMap.containsKey(String.valueOf(initial.charAt(i)))? initialMap.get(initial.charAt(i)) : 0;
			initialMap.put(String.valueOf(initial.charAt(i)), count);
			if (count == 0) {
				differentLettersInitial++;
			}
			if (anagram.charAt(i) == '*') {
				starNumber++;
			} else {
				count = anagramMap.containsKey(String.valueOf(anagram.charAt(i)))? anagramMap.get(anagram.charAt(i)) : 0;
				anagramMap.put(String.valueOf(anagram.charAt(i)), count);
				if (count == 0) {
					differentLettersAnagram++;
				}
			}
		}
		if (differentLettersInitial < differentLettersAnagram) {
			System.out.println("N");
		} else {
			if (starNumber == 0) {
				if (initialMap.equals(anagramMap)) {
					System.out.println("Y");
				}
			}
		}
	}
}
