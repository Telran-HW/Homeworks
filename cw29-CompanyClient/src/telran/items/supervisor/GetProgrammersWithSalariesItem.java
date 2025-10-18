package telran.items.supervisor;

import telran.employees.api.IProgrammer;
import telran.employees.utils.Config;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class GetProgrammersWithSalariesItem extends CompanyItem {

	public GetProgrammersWithSalariesItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "Get Programmers with salaries";
	}

	@Override
	public void perform() {
		
		int salaryFrom = io.inputInteger("Enter programmer salary-FROM in range "+ Config.MIN_SALARY + " - " + Config.MAX_SALARY + " ", Config.MIN_SALARY, Config.MAX_SALARY);
		int salaryTo = io.inputInteger("Enter programmer salary-TO in range "+ Config.MIN_SALARY + " - " + Config.MAX_SALARY + " ", Config.MIN_SALARY, Config.MAX_SALARY);
		//int salaryTo = io.inputInteger("Enter programmer salary-TO in range "+ salaryFrom + " - " + Config.MAX_SALARY + " ", Config.MIN_SALARY, Config.MAX_SALARY);
		if(salaryTo < salaryFrom) {
			io.output("salary-TO must be higher than salary-FROM");
			return;
		}
		
		io.outputLine(company.getProgrammersWithSalaries(salaryFrom, salaryTo));
	}

}
