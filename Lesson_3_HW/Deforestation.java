package Lesson_3_HW;

import java.util.*;

public class Deforestation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] nMass = new int[n];
		for (int i = 0; i < n; i++) {
			nMass[i] = input.nextInt();
		}
		int queries = input.nextInt();
		for (int i = 0 ; i < queries; i++) {
			int firstTree = input.nextInt();
			int lastTree = input.nextInt();
			int total = 0;
			for (int j = firstTree; j <= lastTree; j++) {
				total+= nMass[j];
			}
			System.out.println(total);
		}
	}
}