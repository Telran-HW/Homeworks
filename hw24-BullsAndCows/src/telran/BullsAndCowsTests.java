package telran;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BullsAndCowsTests {
	
	BullsAndCowsGame num = new BullsAndCowsGame();
	int n = num.generateNumber();
//	System.out.println(n);
	
//	System.out.println(score);
//	System.out.println(BullsAndCowsGame.isFinishGame(score));
	
//	@BeforeEach
//	void generateNumber() {
//		number = generateNumber();
//	}
	

	@Test
	void testGenerate() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int temp = n;
		for (int i = 1; i <= BullsAndCowsGame.SIZE; ) {
			int rest = temp % 10;
			list.add(rest);
			temp /= 10;
			i++;
		}
		String str = String.valueOf(n);
		assertEquals(4, str.length());
		assertEquals(4, list.size());
		assertFalse(list.contains(0));
	}
	
	@Test
	void testCheckNumbers() {
		int number = 1234;
		int numUser1 = 4531; // 2 1
		
		Map<String, Integer> score = BullsAndCowsGame.checkNumbers(number, numUser1);
		Map<String, Integer> expected1 = new HashMap<String, Integer>();
		expected1.put("cows", 2);
		expected1.put("bulls", 1);
		assertEquals(expected1, score);
		
		int numUser2 = 1234; // 0 4
		score = BullsAndCowsGame.checkNumbers(number, numUser2);
		Map<String, Integer> expected2 = new HashMap<String, Integer>();
		expected2.put("cows", 0);
		expected2.put("bulls", 4);
		assertEquals(expected2, score);
		
	}
	@Test
	void testIsGameFinish() {
		int number = 1234;
		int numUser1 = 4531; // 2 1
		
		Map<String, Integer> score = BullsAndCowsGame.checkNumbers(number, numUser1);
		assertFalse(BullsAndCowsGame.isGameFinish(score));
		
		int numUser2 = 1234; // 0 4
		score = BullsAndCowsGame.checkNumbers(number, numUser2);
		assertTrue(BullsAndCowsGame.isGameFinish(score));
	}
	

}
