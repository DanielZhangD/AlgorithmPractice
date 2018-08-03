package Lesson_3_HW;

import java.util.Arrays;
import java.util.Scanner;

public class TandemBicycle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		int number = input.nextInt();
		int[] dmojistan = new int[number];
		int[] pegland = new int[number];
		for (int i = 0; i < number; i++) {
			dmojistan[i] = input.nextInt();
		}
		for (int i = 0; i < number; i++) {
			pegland[i] = input.nextInt();
		}
		Arrays.sort(dmojistan);
		Arrays.sort(pegland);
		int sum = 0;
		if (choice == 2) {
			for (int i = 0; i < number; i++) {
				if (dmojistan[i] < pegland[number - i - 1]) {
					sum += pegland[number - i - 1];
				} else {
					sum += dmojistan[i];
				}
			}
		} else if (choice == 1) {
			for (int i = 0; i < number; i++) {
				if (dmojistan[i] > pegland[i]) {
					sum += dmojistan[i];
				} else {
					sum += pegland[i];
				}
			}
		}
		System.out.println(sum);
	}
}
