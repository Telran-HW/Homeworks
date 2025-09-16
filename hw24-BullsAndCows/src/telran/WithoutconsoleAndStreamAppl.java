package telran;

import java.util.ArrayList;
import java.util.Map;

public class WithoutconsoleAndStreamAppl {

	public static void main(String[] args) {

		int size = 4;
		int number = 1234;
		int numUser1 = 4531; // 2 1
		int numUser2 = 4222; // 1 1
		int numUser3 = 1423; // 3 1
		int numUser4 = 1231; // 0 3
		int numUser5 = 4213; // 3 1
		int numUser6 = 1234; // 0 4
		// cows = 2 bulls = 1

		checkNumbers(number, numUser1);
		checkNumbers(number, numUser2);
		checkNumbers(number, numUser3);
		checkNumbers(number, numUser4);
		checkNumbers(number, numUser5);
		checkNumbers(number, numUser6);
		
		BullsAndCowsGame num = new BullsAndCowsGame();
		int n = num.generateNumber();
		
		String str = String.valueOf(n);
		System.out.println(str);
		
		System.out.println(n);
		Map<String, Integer> score = BullsAndCowsGame.checkNumbers(n, numUser1);
		System.out.println(score);
		System.out.println(BullsAndCowsGame.isGameFinish(score));
//		score = BullsAndCowsGame.checkNumbers(n, numUser2);
//		System.out.println(BullsAndCowsGame.isGameFinish(score));
//		score = BullsAndCowsGame.checkNumbers(n, numUser3);
//		System.out.println(BullsAndCowsGame.isGameFinish(score));
//		score = BullsAndCowsGame.checkNumbers(n, numUser4);
//		System.out.println(BullsAndCowsGame.isGameFinish(score));
//		score = BullsAndCowsGame.checkNumbers(n, numUser5);
//		System.out.println(BullsAndCowsGame.isGameFinish(score));
//		score = BullsAndCowsGame.checkNumbers(n, numUser6);
//		System.out.println(BullsAndCowsGame.isGameFinish(score));

	}

	// корова - есть число, но позиция не та
	// бык - число и позиция совпали
	// число генерится от 1 до 9 == нет 0
	// количество цифр 4

	//не знаю как использовать, но пусть будут рассуждения
	// можно предположить, что если из загаданного числа вычесть введенное, то быки это количество 0 в полученном числе

	private static void checkNumbers(int number, int numUser) {

		int cows = 0;
		int bulls = 0;

		int size = 4;
		int tempNum = number;
		int tempNumUser = numUser;

		ArrayList<Integer> listNum = new ArrayList<Integer>();
		ArrayList<Integer> listBulls = new ArrayList<Integer>();

		while (size != 0) {
			int a = tempNum % 10;
			int b = tempNumUser % 10;
			if (a == b) {
				bulls += 1;
				listBulls.add(b);
			}
			listNum.add(a);
			tempNum /= 10;
			tempNumUser /= 10;
			size--;
		}
		size = 4;
		//System.out.println(listNum);
		//System.out.println("Bulls"+listBulls);

		int num = numUser;
		while (size != 0) {
			int m = num % 10;
			//System.out.println("m = " + m);
			if (!listBulls.contains(m)) {
				if (listNum.contains(m)) {
					cows += 1;
					//System.out.println(cows);
				}
			}
			num /= 10;
			size--;
		}

		System.out.println("generated number: " + number + ", user number: " + numUser + ", output: " + cows + " cows; "
				+ bulls + " bulls");

	}

}

