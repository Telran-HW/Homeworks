package telran.items.hr;

import telran.employees.service.IProgrammer;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class RemoveProgrammerItem extends CompanyItem {

	public RemoveProgrammerItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "Fire programmer";
	}

	@Override
	public void perform() {
		Integer id = getAndCheckExistsProgrammerId();
		if(id == null) return;
		
		io.outputLine(company.removeProgrammer(id));
	}

}
