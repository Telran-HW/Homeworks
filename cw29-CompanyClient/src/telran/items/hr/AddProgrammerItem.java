package telran.items.hr;

import telran.employees.api.IProgrammer;
import telran.employees.dto.Programmer;
import telran.employees.utils.Config;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class AddProgrammerItem extends CompanyItem {

	public AddProgrammerItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "Hire programmer";
	}

	@Override
	public void perform() {

		Integer id = getAndCheckNotExistsProgrammerId();
		if(id == null) return;
		
		String progName = io.inputString("Enter programmer name ");
		
		String[] technologies = getTechnologies();
		
		int salary = io.inputInteger("Enter programmer salary from "+ Config.MIN_SALARY + " to " + Config.MAX_SALARY + " ", Config.MIN_SALARY, Config.MAX_SALARY);
		
		Programmer prog;
		try {
			prog = new Programmer(id, progName, technologies , salary);
			io.outputLine(company.addProgrammer(prog));
			//io.outputLine(prog);
		} catch (Exception e) {
			io.outputLine("Something went wrong! Programmer data not added!");
		}
		
		
	
	}

	private String[] getTechnologies() {
		String temp = io.inputString("Enter programmer's technologies separated by comma from list: " + Config.TECHNOLOGY_LIST, Config.TECHNOLOGY_LIST);
		return temp.split(",");
	}

}
