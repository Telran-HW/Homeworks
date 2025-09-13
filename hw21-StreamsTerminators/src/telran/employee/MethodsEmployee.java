package telran.employee;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodsEmployee {

	public static void displayAverageMinMaxSalary(List<Employee> employees) {

		IntSummaryStatistics stats = employees.stream().mapToInt(e -> e.salary).summaryStatistics();

		System.out.println("Average of salary = " + stats.getAverage());
		System.out.println("Minimal of salary = " + stats.getMin());
		System.out.println("Maximal of salary = " + stats.getMax());

	}

	public static void displayAverageSalary(List<Employee> employees, String company) {

		double salaryAvg = employees.stream().mapMultiToDouble((employee, consumer) -> {
			if (employee.company.equals(company))
				consumer.accept(employee.salary);
		}).average().getAsDouble();

		System.out.println(salaryAvg);

	}

	public static void displayEmployeesAvgSalary(List<Employee> employees) {

		double avg = employees.stream().mapToInt(e -> e.salary).average().orElse(0);

		employees.stream().mapMulti((employee, consumer) -> {
			if (employee.salary > avg)
				consumer.accept(new EmployeeNameSalary(employee.name, employee.salary));
		}).toList().forEach(System.out::println);

	}

//	employees.add(new Employee(1, "name1", "company1", 10900));
//	employees.add(new Employee(2, "name2", "company2", 13600));
//	employees.add(new Employee(3, "name61", "company6", 14530));
//	employees.add(new Employee(4, "name4", "company4", 20370));
//	employees.add(new Employee(5, "name5", "company5", 22000));
//	employees.add(new Employee(6, "name62", "company6", 7000));
//	employees.add(new Employee(7, "name34", "company4", 16000));
//	employees.add(new Employee(8, "name63", "company6", 11900));

	public static void displayBiggestCompanies(List<Employee> employees) {

		// делаем коллекцию компания - количество сотрудников
		Map<String, Long> empMap = employees.stream()
				.collect(Collectors.groupingBy(e -> e.company, Collectors.counting()));
				

		// определяем максимальное количество сотрудников по значениям в empMap
		long max = empMap.values().stream().max(Long::compare).orElse(0L);

		// выводим названия компаний с максимальным количество сотрудников
		
		// вариант 1 (первым пришел в голову)
//		List<Object> companies = empMap.entrySet().stream().mapMulti((es, consumer) -> {
//			if (es.getValue() == max)
//				consumer.accept(es.getKey());
//		}).toList();
//		companies.forEach(System.out::println);
		
		//вариант 2
		empMap.entrySet().stream()
		.filter(es -> es.getValue() == max)
		.map(es -> es.getKey())
		.forEach(System.out::println);
		
	}

}
