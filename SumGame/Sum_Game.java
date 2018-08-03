package SumGame;

import java.util.Scanner;

public class Sum_Game {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int games = input.nextInt();
		int[] swift = new int[games];
		int same = 0;
		int swiftTotal = 0;
		int semaphoresTotal = 0;
		for (int i = 0; i < games; i++) {
			int runs = input.nextInt();
			swift[i] = runs + swiftTotal;
			swiftTotal += runs;
		}
		for (int i = 0; i < games; i++) {
			int runs = input.nextInt();
			semaphoresTotal += runs;
			if (semaphoresTotal == swift[i]) {
				same = i + 1;
			}
		}
		System.out.println(same);
	}
}
