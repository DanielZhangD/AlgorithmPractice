package Lesson_3_HW;
//use differenceArray
import java.util.Scanner;

public class BattlePositions {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int stations = input.nextInt();
		int minimum = input.nextInt();
		int waves = input.nextInt();
		int[] differenceArray = new int[stations + 1];
		int[] normalArray = new int[stations];
		int insecure = 0;
		for (int i = 0; i < waves; i++) {
			int firstBase = input.nextInt();
			int lastBase = input.nextInt();
			int soldiers = input.nextInt();
			differenceArray[firstBase - 1] += soldiers;
			differenceArray[lastBase] -= soldiers;
		}
		for (int i = 0; i < stations; i++) {
			if (i > 0) {
				normalArray[i] = differenceArray[i] + normalArray[i - 1];
			} else {
				normalArray[0] = differenceArray[0];
			}
			if (normalArray[i] < minimum) {
				insecure++;
			}
		}
		System.out.println(insecure);
	}
}
