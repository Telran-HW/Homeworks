package telran.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceAppl {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			System.out.print("Enter number >0 of threads: ");
			int numberOfRacers = scanner.nextInt();
			System.out.print("Enter distance >0: ");
			int distance = scanner.nextInt();

			List<Racer> racers = new ArrayList<>();
			for (int i = 0; i < numberOfRacers; i++) {
			
				Racer racer = new Racer(i+1, distance);
				
				racers.add(racer);
				racer.start();
			}
			 
			for (Racer racer : racers) {
				try {
					racer.join();
				
				} catch (InterruptedException e) {
				}
			}
		}
		
		System.out.println("\nCongratulations to thread #" + Racer.winner + " (winner)!");

	}


}
