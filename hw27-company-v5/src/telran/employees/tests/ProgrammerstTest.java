package telran.employees.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.employees.dto.Programmer;
import telran.employees.service.ProgrammerMap;

class ProgrammerstTest {
	private static final String CPP = "c++";
	private static final String JAVA = "java";
	private static final String WEB = "javaScript";
	private static final String SQL = "sql";
	private static final String PYTHON = "python";
	private static final String GO = "go";
	
	private static final int ID_NEW = 1111;
	private static final String FILE_NAME = "programmers_test.data";
	
	static String[] tech1 = {CPP, JAVA, SQL };
	static String[] tech2 = {CPP, WEB };
	static String[] tech3 = {PYTHON, GO, JAVA };
	
	static int salary1 = 10000;
	static int salary2 = 5000;
	static int salary3 = 15000;
	
	static Programmer prog1, prog2, prog3;
	
	//IProgrammer programmerService;
	static ProgrammerMap programmerService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		prog1 = new Programmer(1, "name1", tech1, salary1);
		prog2 = new Programmer(2, "name2", tech2, salary2);
		prog3 = new Programmer(3, "name3", tech3, salary3);
		Programmer[] progs = {prog1, prog2, prog3};
		
		programmerService = new ProgrammerMap();
		for(Programmer p : progs)
		programmerService.addProgrammer(p);
		
		programmerService.save(FILE_NAME);
	}

	@BeforeEach
	void setUp() throws Exception {
		programmerService = ProgrammerMap.restoreFromFile(FILE_NAME);
	}

	@Test
	void testAddProgrammer() throws Exception {
		assertFalse(programmerService.addProgrammer(new Programmer(1, "name1", tech1, salary1)));
		assertTrue(programmerService.addProgrammer(new Programmer(ID_NEW, "name", new String[] {GO}, 20000)));
		assertNotNull(programmerService.getProgrammerData(ID_NEW));
		assertFalse(programmerService.addProgrammer(null));
		
		System.out.println(programmerService.getProgrammersWithSalaries(0,  20001));
		
		try {
			programmerService.addProgrammer(new Programmer(1, null, tech1, salary1));
			fail("Exception expected");
		}catch (Exception e) {
			assertEquals("Wrong data. Programmer not created", e.getMessage());
		}
		System.out.println(programmerService.getAllProgrammers());
		
	}

	@Test
	void testRemoveProgrammer()
	{
		System.out.println(programmerService.getAllProgrammers());
		assertFalse(programmerService.removeProgrammer(ID_NEW));
		assertTrue(programmerService.removeProgrammer(1));
		assertNull(programmerService.getProgrammerData(1));
	}

	@Test
	void testGetProgrammerData() 	{
		System.out.println(programmerService.getAllProgrammers());
		assertEquals(prog1, programmerService.getProgrammerData(1));
		assertEquals(prog2, programmerService.getProgrammerData(2));
		assertNull(programmerService.getProgrammerData(ID_NEW));
	}

	@Test
	void testAddNewTechnology()	{
		System.out.println(programmerService.getAllProgrammers());
		assertFalse(prog2.getTechnologies().contains(JAVA));
		programmerService.addNewTechnology(2, JAVA);
//		System.out.println(programmerService.getProgrammerData(2));
//		assertTrue(prog2.getTechnologies().contains(JAVA));
	}

	@Test
	void testRemoveTechnology()	{
		System.out.println(programmerService.getAllProgrammers());
		assertTrue(prog1.getTechnologies().contains(JAVA));
		programmerService.removeTechnology(1, JAVA);
		assertFalse(prog2.getTechnologies().contains(JAVA));
	}

	@Test
	void testGetProgrammersWithTechnology()	{
		System.out.println(programmerService.getAllProgrammers());
		List<Programmer> programmers = 
				programmerService.getProgrammersWithTechnology(JAVA);
		assertEquals(2, programmers.size());
		assertTrue(programmers.contains(prog1));
		assertTrue(programmers.contains(prog3));
	}

	@Test
	void testGetProgrammersWithSalaries()	{
		List<Programmer> programmers = 
				programmerService.getProgrammersWithSalaries(5000, 11000);
		assertEquals(2, programmers.size());
		assertTrue(programmers.contains(prog1));
		assertTrue(programmers.contains(prog2));
	}

	@Test
	void testUpdateSalary()	{
		Programmer programmer = programmerService.getProgrammerData(2);
		assertEquals(salary2, programmer.getSalary());
		programmerService.updateSalary(2, salary3);
		programmer = programmerService.getProgrammerData(2);
		assertEquals(salary3, programmer.getSalary());
	}
	@Test
	void testConvertBaseToTechProgrammersMap() {
		Map <String, Set<Programmer>> testMap = programmerService.convertBaseMapToTechProgrammersMap();
		System.out.println(testMap);
		assertEquals(6, testMap.keySet().size());
		assertArrayEquals( new Programmer[] {prog1, prog3}, testMap.get(JAVA).toArray(new Programmer[0]));
		System.out.println(new Programmer[] {prog1, prog3});
	}
	
	@Test
	void testConvertOtherToTechProgrammersMap() {
		Map <Integer, Programmer> testMap = Map.of(1, prog1, 2, prog2, 3, prog3);
		Map <String, Set<Programmer>> testRes = ProgrammerMap.convertOtherMapToTechProgrammersMap(testMap);
		assertEquals(6, testRes.keySet().size());
		assertArrayEquals( new Programmer[] {prog1, prog3}, testRes.get(JAVA).toArray(new Programmer[0]));
	}
}
