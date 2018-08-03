package Sawmill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sawmill {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sawLogs = input.nextInt();
		ArrayList<Integer> logLengths = new ArrayList<Integer>();
		ArrayList<Integer> sawConsumption = new ArrayList<Integer>();
		for (int i = 0; i < sawLogs; i++) {
			logLengths.add(input.nextInt());
		}
		for (int i = 0; i < sawLogs; i++) {
			sawConsumption.add(input.nextInt());
		}
		Collections.sort(logLengths, Collections.reverseOrder());
		Collections.sort(sawConsumption);
		long totalValue = 0;
		for (int i = 0; i < sawLogs; i++) {
			totalValue = totalValue + (logLengths.get(i) * sawConsumption.get(i));
		}
		System.out.println(totalValue);
	}
}
