package HighTideLowTide;

import java.util.Scanner;
import java.util.Arrays;

public class High_Tide_Low_Tide {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		int middle = cases / 2;
		int[] tides = new int[cases];
		if (cases % 2 != 0) {
			middle += 1;
		}
		for (int i = 0; i < cases; i++) {
			tides[i] = input.nextInt();
		}
		Arrays.sort(tides);
		for (int i = 0; i < middle; i++) {
			if (i != middle - 1) {
				System.out.print(tides[middle - i -1] + " " + tides[middle + i] + " ");
			} else {
				if (cases % 2 != 0) {
					System.out.print(tides[middle - i - 1]);
				} else {
					System.out.print(tides[middle - i - 1] + " " + tides[middle + i] + " ");
				}
			}
		}
	}
}
