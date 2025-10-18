package telran.employees.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SalaryId implements Serializable {

	int id;
	int salary;
	
	public SalaryId(int id, int salary) {
		super();
		this.id = id;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
