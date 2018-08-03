package Lesson_3_HW;
//Use Prefix Sum Array

import java.util.Scanner;

//DIFFERENCE ARRAY
/*
 * Create a new array where you replace each element by the difference between the the original element and the previous element
 * Good when ranges of said array can be updated all at once
 * Convert difference array back to normal array by performing a prefix array calculation
 */
//Prefix sum array
/*
 * One array in which every single element bbecomes the sum of itself and all elements preceding it
 * much easier to use
 * Good for range sums (query from i to j what the sum is) (i.e. exactly this problem(
 */
//both carry out reverse processes
public class Deforestation2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] nMass = new int[n];
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				nMass[i] = input.nextInt() + nMass[i - 1];
			} else {
				nMass[i] = input.nextInt();
			}
		}
		int queries = input.nextInt();
		for (int i = 0; i < queries; i++) {
			int first = input.nextInt();
			int second = input.nextInt();
			if (first != 0) {
				System.out.println(nMass[second] - nMass[first - 1]);
			} else {
				System.out.println(nMass[second]);
			}
		}
	}
}
