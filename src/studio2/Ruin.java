package studio2;

import java.util.Scanner;

public class Ruin {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Start Amount: ");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.println("Win Limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Simulations: ");
		int totalSimulations = in.nextInt();
		int rounds = 0;
		int losses = 0;
		
		for (int simulation = 1; simulation <= totalSimulations; simulation++) {
			double currentAmount = startAmount;
			rounds = 0;
			while (currentAmount < winLimit && currentAmount > 0) {
				if (Math.random() < winChance) {
					currentAmount += 1;
				}
				else {
					currentAmount -= 1;
				}
				rounds++;
			}
			
			if (currentAmount == winLimit) {
				System.out.println("Simulation " + simulation + ": " + rounds + " WIN");
			}
			else {
				System.out.println("Simulation " + simulation + ": " + rounds + " LOSE");
				losses++;

			}
			
		}
		double expectedRuinRate;
		double a = (1.0 - winChance)/(double)(winChance);
		if (winChance == 0.5) {
			expectedRuinRate = 1.0 - (startAmount/(double)winLimit);
		}
		else {
			expectedRuinRate = (Math.pow(a,startAmount) - Math.pow(a,winLimit)) / (1-Math.pow(a,winLimit));
		}
		double ruinRate = Math.round(((double)losses / (double)totalSimulations) * 100.0) / (double)100;
		System.out.println("Losses: "+ losses + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuinRate);
}
}