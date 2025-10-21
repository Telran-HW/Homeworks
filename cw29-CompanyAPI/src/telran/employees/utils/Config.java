package telran.employees.utils;

import java.util.List;

public class Config {
	
	public static final String FILE_NAME = "programmers.data";
	public static final int MIN_ID = 0;
	public static final int MAX_ID = 999_999_999;
	public static final int MIN_SALARY = 6_000;
	public static final int MAX_SALARY = 150_000;
	public static final List<String> TECHNOLOGY_LIST = List.of(
			"Java",
			"JavaScript",
			"NodeJS",
			"C++",
			"Go",
			"Python",
			"Sql"
			);
	

}
