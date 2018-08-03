package ToweringTowers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ToweringTowersBuffered {
	public static void main(String args[]) {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String bufferedInput = null;
		int towers = 0;
		try {
			bufferedInput = bi.readLine();
			towers = Integer.parseInt(bufferedInput);
			bufferedInput = bi.readLine();
		} catch (IOException e) {
		}
		String[] bufferedIntegers = bufferedInput.split(" ");
		int[] heights = new int[towers];
		int[] seeable = new int[towers];
		for (int i = 0; i < towers; i++) {
			heights[i] = Integer.parseInt(bufferedIntegers[i]);
		}
		int canSee = 0;
		for (int i = 0; i < towers; i++) {
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
