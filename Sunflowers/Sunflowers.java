package Sunflowers;
import java.util.Scanner;

public class Sunflowers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int[][] field = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0 ; j < length; j++) {
				field[i][j] = input.nextInt();
			}
		}
		if (field[0][0] < field[0][1] && field[0][0] < field[1][0]) {
			//System.out.println("1");
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					System.out.print(field[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		} else if (field[0][0] > field[0][1] && field[0][0] > field[1][0]) {
			//System.out.println("2");
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					System.out.print(field[length - 1 - i][length - 1 - j] + " ");
				}
				System.out.println();
			}
		} else if (field[length - 1][length - 1] > field[length - 1][length - 2] && field[length - 1][length - 1] < field[length - 2][length - 1]){
			//System.out.println("3");
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					System.out.print(field[length - 1 - j][i] + " ");
				}
				System.out.println();
			}
		} else {
			//System.out.println("4");
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					System.out.print(field[j][length - 1 - i] + " ");
				}
				System.out.println();
			}
		}
	}
}
