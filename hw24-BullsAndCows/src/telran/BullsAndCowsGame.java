package telran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class BullsAndCowsGame {

	static public final int SIZE = 4;
	static public final int START = 1;
	static public final int END = 10;
	int number;
	int numUser;
	Random rnd;
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	Map<String, Integer> mapCowsAndBulls;

	public BullsAndCowsGame() {
		
	}

	public int generateNumber() {
		rnd = new Random();
		int num = 0;
		int mn = 1000;
		for (int i = 1; i <= SIZE;) {
			num = rnd.nextInt(START, END);
			if (!list.contains(num)) {
				list.add(num);
				number += num * mn;
				i++;
				mn /= 10;
			}

		}
		//System.out.println(list);
		return number;

	}
	

	@Override
	public String toString() {
		// return "BullsAndCowsGame [number=" + number + "]";
		return "generated number: " + number + ", user number: " + numUser + ", output: " + mapCowsAndBulls + " cows; ";
		// + mapCowsAndBulls.bulls + " bulls";
	};

	public static Map<String, Integer> checkNumbers(int number, int numUser) {

		Map<String, Integer> mapCowsAndBulls = new HashMap<>();

		int cows = 0;
		int bulls = 0;

		int size = 4;
		int tempNum = number;
		int tempNumUser = numUser;

		ArrayList<Integer> listNum = new ArrayList<Integer>();
		ArrayList<Integer> listBulls = new ArrayList<Integer>();

		for (int i = 1; i <= SIZE;) {
			int a = tempNum % 10;
			int b = tempNumUser % 10;
			if (a == b) {
				bulls += 1;
				listBulls.add(b);
			}
			listNum.add(a);
			tempNum /= 10;
			tempNumUser /= 10;
			i++;
		}
		size = 4;
		// System.out.println(listNum);
		// System.out.println("Bulls"+listBulls);

		int num = numUser;
		for (int i = 1; i <= SIZE;) {
			int m = num % 10;
			// System.out.println("m = " + m);
			if (!listBulls.contains(m)) {
				if (listNum.contains(m)) {
					cows += 1;
					// System.out.println(cows);
				}
			}
			num /= 10;
			i++;
		}

		mapCowsAndBulls.put("cows", cows);
		mapCowsAndBulls.put("bulls", bulls);

		System.out.println("generated number: " + number + ", user number: " + numUser + ", output: " + cows + " cows; "
				+ bulls + " bulls");
		return mapCowsAndBulls;
	}

	public static boolean isGameFinish(Map<String, Integer> score) {
		for (Entry<String, Integer> e : score.entrySet()) {
			if (e.getKey().contains("bulls")) {
				if (e.getValue() == 4)
					return true;
			}
		}
		return false;
	}
	
	
}
