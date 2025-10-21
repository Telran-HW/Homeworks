package telran.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import telran.utils.Constants;

@SuppressWarnings("serial")
public class Move implements Serializable{

	//int number;
	//int numUser;
	//boolean stopGame;
	List<Integer> secretNumber;
	Map<String, Integer> mapCowsAndBulls;
	Random rnd;

	public Move() {
		//stopGame = false;
		secretNumber = generateNumber();
	}

	private List<Integer> generateNumber() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		rnd = new Random();
		int num = 0;
		for (int i = 1; i <= Constants.SIZE;) {
			num = rnd.nextInt(Constants.START, Constants.END);
			if (!list.contains(num)) {
				list.add(num);
				i++;
			}
		}
		return list;
	}

	private List<Integer> getUserNumber(String str) {
		return str.chars().map(Character::getNumericValue).boxed().toList();
	}

	public Map<String, Integer> getScore(String num){
		
		List<Integer> numberUser = getUserNumber(num);
		Map<String, Integer> score = new HashMap<>();

		int cows = 0;
		int bulls = 0;

		for (int i = 0; i < secretNumber.size(); i++) {
			if (secretNumber.contains(numberUser.get(i))) {
				if (secretNumber.get(i) != numberUser.get(i)) {
					cows++;
				} else
					bulls++;
			}
		}
		score.put("cows", cows);
		score.put("bulls", bulls);

		return score;
	}
	
//	public static boolean isGameFinish(Map<String, Integer> score) {
//	for (Entry<String, Integer> e : score.entrySet()) {
//		if (e.getKey().equals("bulls")) {
//			if (e.getValue() == 4)
//				return true;
//		}
//	}
//	return false;
//}


	
}
