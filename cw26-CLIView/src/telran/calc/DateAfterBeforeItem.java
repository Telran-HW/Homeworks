package telran.calc;

import telran.view.InputOutput;
import telran.view.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
public class DateAfterBeforeItem implements Item {
	
	public static final String FORMAT = "yyyy-MM-dd";
	
	InputOutput inOut;
	static Map<String, BiFunction<LocalDate, Long, LocalDate>> mapDates;
	
	static {
		mapDates = new HashMap<>();
		mapDates.put("before", (a, b) -> a.minusDays(b));
		mapDates.put("after", (a, b) -> a.plusDays(b));
	}
	

	public DateAfterBeforeItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

	@Override
	public String displayedName() {
		return "Calculator of date after or before entered date";
	}

	@Override
	public void perform() {
		LocalDate dateStart = inOut.inputDate("Enter date in format " + FORMAT, FORMAT);
		if(dateStart == null) return;
		Long number = inOut.inputLong("Enter number of days ");
		if(number == null) return;
		String condition = inOut.inputString("Enter condition 'after' or 'before' ");
		if(condition == null) return;
		inOut.outputLine(mapDates.get(condition).apply(dateStart, number));
		
	}

}
