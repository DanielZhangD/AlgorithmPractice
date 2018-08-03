package UnevenSands;

import java.util.Scanner;

public class UnevenSandsAnswer {
	
	public static void main(String args[]) {
		long max = (long)(2 * Math.pow(10, 9));
		Scanner input = new Scanner(System.in);
		long min = 0;
		String response = "";
		long i = max / 2;
		while (!response.equals("OK")) {
			System.out.println(i);
			System.out.flush();
			response = input.nextLine();
			if (response.equals("SINKS")) {
				min = i;
				i = (min + max) / 2;
			} else if (response.equals("FLOATS")) {
				max = i;
				i = (min + max) / 2;
			} else {
				break;
			}
		}
	}
}
