package Lesson_4_HW;

import java.util.Scanner;

public class LilJami {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cups = input.nextInt();
		int[] cupArrayNormal = new int[cups];
		int stones = input.nextInt();
		for (int i = 0; i < stones; i++) {
			int location = input.nextInt();
			cupArrayNormal[location]++;
		}
		for (int i = 0; i < cups; i++) {
			if (i > 0) {
				cupArrayNormal[i] += cupArrayNormal[i - 1];
			}
		}
		
		int queries = input.nextInt();
		for (int i = 0; i < queries; i++) {
			int startValue = input.nextInt();
			int endValue = input.nextInt();
			if (startValue != 0) {
				System.out.println(cupArrayNormal[endValue] - cupArrayNormal[startValue - 1]);
			} else {
				System.out.println(cupArrayNormal[endValue]);
			}
		}
	}
}
