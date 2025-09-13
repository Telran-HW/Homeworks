package telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import telran.employee.Employee;
import telran.employee.MethodsEmployee;

public class EmployeeAppl {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "name14", "company4", 10900));
		employees.add(new Employee(2, "name2", "company2", 13600));
		employees.add(new Employee(3, "name61", "company6", 14530));
		employees.add(new Employee(4, "name4", "company4", 20370));
		employees.add(new Employee(5, "name5", "company5", 22000));
		employees.add(new Employee(6, "name62", "company6", 7000));
		employees.add(new Employee(7, "name34", "company4", 16000));
		employees.add(new Employee(8, "name63", "company6", 11900));

//		MethodsEmployee.displayAverageMinMaxSalary(employees);
//		MethodsEmployee.displayAverageSalary(employees, "company6");
//		MethodsEmployee.displayEmployeesAvgSalary(employees);
//
//		int[] ar = { -9, 0, 5, 6, 7, 89, 10020 };
//		displayShuffledArray(ar);
//
//		int min = 1;
//		int max = 49;
//		int numberDigits = 7;
//		sportLoto(min, max, numberDigits);

		// ===============HW21======================

		MethodsEmployee.displayBiggestCompanies(employees);

		System.out.println("============");

		String text = "lmn, vf ab a lmn: ab lmn";
		displayWordCounts(text);
		System.out.println("=====1.2=======");
		displayWordCounts1(text);
		System.out.println("======2======");
		String text1 = "a, ab, fr, ab, q, as, a, ert, ert, wer, w, a, q, q, tyu, q";
		displayWordCounts(text1);
		System.out.println("=====2.2=======");
		displayWordCounts1(text1);

	}

	private static void displayWordCounts(String text) {

//		String[] texts = text.replaceAll("[!,./:;]+", "").trim().split(" ");
		String[] texts = text.split("[^a-zA-Z]+"); //разсплитить по НЕ буквам

		// Map<String, Long> map =
		Arrays.stream(texts)
		//.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.collect(Collectors.toMap(w -> w,  w -> 1, (v1,v2) -> v1+v2))
			.entrySet().stream()
				.sorted((es1, es2) -> {
					return es1.getValue() != es2.getValue() ? es2.getValue().compareTo(es1.getValue())
							: es1.getKey().compareTo(es2.getKey());
				})
//				.forEach(System.out::println);
				.forEach(e -> System.out.printf("%s=> %d\n", e.getKey(), e.getValue()));
	}
	
	private static void displayWordCounts1(String text) {
		
		String[] words = text.split("[^a-zA-Z]+");
		
		Arrays.stream(words)
			.map(w -> w.trim())
			.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
			.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed()
					.thenComparing(Map.Entry.<String, Long>comparingByKey()))
			.forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
		
	}

	private static void sportLoto(int min, int max, int numberDigits) {

		Random rnd = new Random();

		int[] arr = IntStream.generate(() -> rnd.nextInt(min, max)).distinct().limit(numberDigits).toArray();
		System.out.println(Arrays.toString(arr));

	}

	private static void displayShuffledArray(int[] ar) {

		List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());

		// List<int[]> list = Arrays.asList(ar);
		Collections.shuffle(list);
		System.out.println(list);

	}

}
