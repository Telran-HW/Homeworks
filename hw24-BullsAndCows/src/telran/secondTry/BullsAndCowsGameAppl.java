package telran.secondTry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BullsAndCowsGameAppl {

	private static final int SIZE = 4;

	public static void main(String[] args) throws IOException {

		boolean stopGame = false;

		Set<Integer> numberSet = generateNumber();

		while (!stopGame) {
			Scanner sc = new Scanner(System.in);
			int numberUser = sc.nextInt();

			int bulls = countCowsAndBulls(numberSet, numberUser);
			//System.out.println(bulls);
			if (bulls == 4)
				stopGame = true;


		}

	}

	public static int countCowsAndBulls(Set<Integer> numberSet, int numberUser) {
		int cows = 0;
		int bulls = 0;

		Set<Integer> numberUserSet = new LinkedHashSet<Integer>();
		int temp = numberUser;
		int del = 1000;
		for (int i = 0; i < SIZE; i++) {
			numberUserSet.add(temp / del);
			temp = temp % del;
			del /= 10;
			
		}
		System.out.println(numberUserSet);
		Iterator<Integer> iterNum = numberSet.iterator();
		Iterator<Integer> iterNumUser = numberUserSet.iterator();
		
		ArrayList<Integer> listNumberOfBulls = new ArrayList<Integer>();
		
		for (int i = 0; i < SIZE; i++) {
//			System.out.println("num "+ iterNum.next());
//			System.out.println("numUser " +  iterNumUser.next());
			int numUser = iterNumUser.next();
			if(iterNum.next() == numUser) {
				listNumberOfBulls.add(numUser);
				bulls++;
			}
			else if(numberSet.contains(numUser) && !listNumberOfBulls.contains(numUser)) {
				cows++;
			}
			
		}

		System.out.println("generated number: " + numberSet + ", user number: " + numberUserSet + ", output: " + cows
				+ " cows; " + bulls + " bulls");
		return bulls;
	}

//	public static int countCowsAndBulls(Set<Integer> numberSet, Set<Integer> numberUserSet) {
//		int cows = 0;
//		int bulls = 0;
//		
//		Iterator<Integer> iterNum = numberSet.iterator();
//		Iterator<Integer> iterNumUser = numberUserSet.iterator();
//		
//		ArrayList<Integer> listNumberOfBulls = new ArrayList<Integer>();
//		
//		for (int i = 0; i < SIZE; i++) {
////			System.out.println("num "+ iterNum.next());
////			System.out.println("numUser " +  iterNumUser.next());
//			int numUser = iterNumUser.next();
//			if(iterNum.next() == numUser) {
//				listNumberOfBulls.add(numUser);
//				bulls++;
//			}
//			else if(numberSet.contains(numUser) && !listNumberOfBulls.contains(numUser)) {
//				cows++;
//			}
//			
//		}
//		System.out.println("generated number: " + numberSet + ", user number: " + numberUserSet + ", output: " + cows + " cows; "
//				+ bulls + " bulls");
//		return bulls;
//	}

	public static Set<Integer> generateNumber() {
		Set<Integer> numberSet = new LinkedHashSet<Integer>();
		while (numberSet.size() < SIZE) {
			Random rnd = new Random();
			int temp = rnd.nextInt(1, 10);
			numberSet.add(temp);
		}
		System.out.println(numberSet);
		return numberSet;
	}

}
