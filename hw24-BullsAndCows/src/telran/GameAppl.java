package telran;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class GameAppl {

	public static void main(String[] args) throws IOException {
		
		boolean stopGame = false;
		List<String> protocol  = new ArrayList<>();
		int moveCount = 0;

		BullsAndCowsGame num = new BullsAndCowsGame();
		int n = num.generateNumber();

		System.out.println(n);

//		while (!stopGame) {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("Enter four-digit number: ");
//			int numberUser = sc.nextInt();
//
//			Map<String, Integer> score = BullsAndCowsGame.checkNumbers(n, numberUser);
//			System.out.println(score);
//			stopGame = BullsAndCowsGame.isGameFinish(score);
//
//		}
		 do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter four-digit number: ");
			int numberUser = sc.nextInt();

			Map<String, Integer> score = BullsAndCowsGame.checkNumbers(n, numberUser);
			//System.out.println(score);
			
			moveCount++;
			protocol.add("move:" + moveCount + " number:" +  numberUser + " " + score);
			System.out.println(protocol);
			stopGame = BullsAndCowsGame.isGameFinish(score);

		} while (!stopGame);
		System.out.print("You win!");
	}

}
