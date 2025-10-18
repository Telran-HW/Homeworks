package telran.employees.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SalaryFromTo implements Serializable {

	int from;
	int to;
	
	public SalaryFromTo(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
	
	
	
	
}
