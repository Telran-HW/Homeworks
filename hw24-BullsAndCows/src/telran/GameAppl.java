package telran;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class GameAppl {

	public static void main(String[] args) throws IOException {
		
		boolean stopGame = false;

		BullsAndCowsGame num = new BullsAndCowsGame();
		int n = num.generateNumber();

		System.out.println(n);

		while (!stopGame) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter four-digit number: ");
			int numberUser = sc.nextInt();

			Map<String, Integer> score = BullsAndCowsGame.checkNumbers(n, numberUser);
			System.out.println(score);
			stopGame = BullsAndCowsGame.isGameFinish(score);

		}
		System.out.print("You win!");
	}

}
