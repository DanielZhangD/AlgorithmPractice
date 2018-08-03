package Lesson_3_HW;

import java.util.Scanner;

public class Arrival_Time {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String time = input.nextLine();
		String[] parts = time.split(":");
		int hours = Integer.valueOf(parts[0]);
		int minutes = Integer.valueOf(parts[1]);
		int timePassed = 0;
		if ((hours > 10 && hours < 12) || (hours > 19) || (hours < 4)) {
			if (hours < 4) {
				System.out.println("0" + (2 + hours) + ":" + parts[1]);
			} else if (hours < 22) {
				System.out.println((2 + hours) + ":" + parts[1]);
			}
			if (hours + 2 == 24) {
				System.out.println("00:" + parts[1]);
			} else if (hours + 2 == 25) {
				System.out.println("01:" + parts[1]);
			}
		} else {
			while (timePassed <= 115) {
				if ((hours >= 7 && hours < 10) || (hours >= 15 && hours < 19)) {
					timePassed += 5;
					minutes += 10;
				} else {
					timePassed += 10;
					minutes += 10;
				}
				if (minutes == 60) {
					minutes = 0;
					hours++;
				}
			}
			if (timePassed == 115) {
				if (hours >= 7 || hours < 10 || hours >= 15 || hours < 19) {
					timePassed += 5;
					minutes += 10;
				} else {
					timePassed += 5;
					minutes += 5;
				}
			}
			if (hours < 10) {
				System.out.print("0" + hours + ":");
			} else {
				System.out.print(hours + ":");
			}
			if (minutes < 10) {
				System.out.println("0" + minutes);
			} else {
				System.out.println(minutes);
			}
		}
	}
}
