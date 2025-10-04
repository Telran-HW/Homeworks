package telran.calc;

import telran.view.InputOutput;
import telran.view.Item;

import java.time.LocalDate;
//import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DaysBetweenItem implements Item{
	
	public static final String FORMAT = "yyyy-MM-dd";
	
	InputOutput inOut;

	public DaysBetweenItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

	@Override
	public String displayedName() {
		return "Calculator of numbers between dates";
	}

	@Override
	public void perform() {
		LocalDate date1 = inOut.inputDate("Enter first date in format " + FORMAT, FORMAT);
		if(date1 == null) return;
		LocalDate date2 = inOut.inputDate("Enter second date in format" + FORMAT, FORMAT);
		if(date2 == null) return;
//		inOut.outputLine(Period.between(date1, date2));
		inOut.outputLine(ChronoUnit.DAYS.between(date1, date2));
		
	}
	
	

}
