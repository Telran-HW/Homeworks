package telran.employee;

public class EmployeeNameSalary{
	
	String name;
	int salary;
	
	public EmployeeNameSalary(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeNameSalary [name=" + name + ", salary=" + salary + "]";
	}



}
