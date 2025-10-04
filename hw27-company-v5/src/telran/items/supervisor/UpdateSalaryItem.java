package telran.items.supervisor;

import telran.employees.service.IProgrammer;
import telran.employees.utils.Config;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class UpdateSalaryItem extends CompanyItem{

	public UpdateSalaryItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "Update salary";
	}

	@Override
	public void perform() {
		
		Integer id = getAndCheckExistsProgrammerId();
		if(id == null) return;
		
		int salary = company.getProgrammerData(id).getSalary();
		
		int newSalary = io.inputInteger("The salary is = " + salary + " Enter new programmer salary " + " from " + 
		+ Config.MIN_SALARY + " to " + Config.MAX_SALARY + " ", Config.MIN_SALARY, Config.MAX_SALARY);
		
		io.outputLine(company.updateSalary(id, newSalary));
		
	}

}
