package VoronoiVillages;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Voronoi_Villages {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int villages = input.nextInt();
		double[] villageLocations = new double[villages];
		for (int i = 0; i < villages; i++) {
			villageLocations[i] = input.nextInt();
		}
		Arrays.sort(villageLocations);
		double smallestDistance = Integer.MAX_VALUE;
		for (int i = 1 ; i < villages - 1; i++) {
			double distance = (villageLocations[i] - villageLocations[i - 1]) / 2 + (villageLocations[i + 1] - villageLocations[i]) / 2;
			if (distance < smallestDistance) {
				smallestDistance = distance;
			}
		}
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(1);
		df.setMinimumFractionDigits(1);
		
		System.out.println(df.format(smallestDistance));
	}
}
