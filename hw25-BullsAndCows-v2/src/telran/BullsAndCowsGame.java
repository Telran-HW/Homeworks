package telran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class BullsAndCowsGame {

	static public final int SIZE = 4;
	static public final int START = 1;
	static public final int END = 10;
	Random rnd;
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	Map<String, Integer> mapCowsAndBulls;

	public BullsAndCowsGame() {
		
	}

	public List<Integer> generate() {
		rnd = new Random();
		int num = 0;
		for (int i = 1; i <= SIZE;) {
			num = rnd.nextInt(START, END);
			if (!list.contains(num)) {
				list.add(num);
				i++;
			}
		}
		//System.out.println(list);
		return list;

	}
	

//	@Override
//	public String toString() {
//		for (Entry<String, Integer> e : mapCowsAndBulls.entrySet()) {
//			return e.getKey() + " " + e.getValue();
//		}
//		return mapCowsAndBulls +"";
//	};

	public static Map<String, Integer> checkNumbers(List<Integer> numberList, List<Integer> numUserList) {

		Map<String, Integer> mapCowsAndBulls = new HashMap<>();

		int cows = 0;
		int bulls = 0;

		for (int i = 0; i < numberList.size(); i++) {
			if (numberList.contains(numUserList.get(i))) {
				if (numberList.get(i) != numUserList.get(i)) {
					cows++;
					
					// System.out.println(cows);
				}
				else bulls++;
			}
		}

		mapCowsAndBulls.put("cows", cows);
		mapCowsAndBulls.put("bulls", bulls);

		for (Entry<String, Integer> e : mapCowsAndBulls.entrySet()) {
			System.out.printf(e.getKey() + " " + e.getValue() + " ");
		}
		System.out.println("\n");
//		System.out.println("generated number: " + number + ", user number: " + numUser + ", output: " + cows + " cows; "
//				+ bulls + " bulls");
		return mapCowsAndBulls;
	}

	public static boolean isGameFinish(Map<String, Integer> score) {
		for (Entry<String, Integer> e : score.entrySet()) {
			if (e.getKey().equals("bulls")) {
				if (e.getValue() == 4)
					return true;
			}
		}
		return false;
	}
	
	
}
