package telran.secondTry;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class BullsAndCowsGameTest {
	
	Set<Integer> numberSet = BullsAndCowsGameAppl.generateNumber();

	@Test
	void generateTest() {
		assertEquals(4, numberSet.size());
		assertFalse(numberSet.contains(0));
	}
	
	@Test
	void countCowsAndBullsTest() {
		Set<Integer> numSet = new LinkedHashSet<Integer>();
		numSet.add(1);
		numSet.add(3);
		numSet.add(2);
		numSet.add(4);
		
		int numberUser = 1234;
		
		int expectedBulls = 2;
		assertEquals(expectedBulls, BullsAndCowsGameAppl.countCowsAndBulls(numSet, numberUser));
	}

}
