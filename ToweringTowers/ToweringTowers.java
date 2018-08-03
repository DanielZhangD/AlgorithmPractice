package ToweringTowers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ToweringTowers {
	public static void main(String args[]) {

		//int towers = Integer.valueOf(bufferedInput);
		Scanner input = new Scanner(System.in);
		int towers = input.nextInt();
		int[] heights = new int[towers];
		int[] seeable = new int[towers];
		int canSee = 0;
		for (int i = 0; i < towers; i++) {
			heights[i] = input.nextInt();
			canSee = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] <= heights[i]) {
					int tempSee = seeable[j];
					if (tempSee > 1) {
						j = j - tempSee + 1;
						canSee += tempSee;
					} else {
						canSee++;
					}
					if (heights[j] > heights[i]) {
						canSee++;
						seeable[i] = canSee;
						break;
					}
				} else {
					canSee++;
					seeable[i] = canSee;
					break;
				}
			}
			System.out.print(canSee + " ");
		}
	}
}
