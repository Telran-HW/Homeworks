package telran.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item{
	
	InputOutput inOut;
	static Map<String, BinaryOperator<Integer>> mapOperations;

	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (a, b) -> a + b);
		mapOperations.put("*", (a, b) -> a * b);
		mapOperations.put("-", (a, b) -> a - b);
		mapOperations.put("/", (a, b) -> b==0? null: a/b);
	}

	public CalculatorItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

	@Override
	public String displayedName() {
		return "Integer numbers calculator";
	}

	@Override
	public void perform() {
		Integer op1 = inOut.inputInteger("Enter first number ");
		if(op1 == null) return;
		Integer op2 = inOut.inputInteger("Enter second number ");
		if(op2 == null) return;
		String operator = inOut.inputString("Enter operator from ", 
				new ArrayList<>(mapOperations.keySet()));
		if(operator == null) return;
		inOut.outputLine(mapOperations.get(operator).apply(op1, op2));
	}

	
	
	
	
	
	
	
	
	
	
	
}
