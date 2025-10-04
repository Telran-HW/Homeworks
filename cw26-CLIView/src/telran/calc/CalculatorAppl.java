package telran.calc;

import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class CalculatorAppl {

	public static void main(String[] args) {
		
//		InputOutput io = new ConsoleInputOutput();
//		Item[] items = {
//				new CalculatorItem(io),
//				new ExitItem()
//		};
//		
//		Menu menu =  new Menu(items, io);
//		menu.runMenu();

//		System.out.println("===============HW26==================");
//		System.out.println("=============== - 1 - ==================");
//		
////		InputOutput ioDate = new ConsoleInputOutput();
////		Item[] itemsDate = {
////				new DateAfterBeforeItem(ioDate),
////				new ExitItem()
////		};
////		
////		Menu menuDate =  new Menu(itemsDate, ioDate);
////		menuDate.runMenu();
//		
//		System.out.println("=============== - 2 - ==================");
//		
//		InputOutput ioDaysBetween = new ConsoleInputOutput();
//		Item[] itemsDaysBetween = {
//				new DaysBetweenItem(ioDaysBetween),
//				new ExitItem()
//		};
//		
//		Menu menuDaysBetween =  new Menu(itemsDaysBetween, ioDaysBetween);
//		menuDaysBetween.runMenu();
		
		InputOutput io = new ConsoleInputOutput();
		Item[] items = {
				new CalculatorItem(io),
				new DateAfterBeforeItem(io),
				new DaysBetweenItem(io),
				new ExitItem()
		};
		
		Menu menu =  new Menu(items, io);
		menu.runMenu();
	}

}
