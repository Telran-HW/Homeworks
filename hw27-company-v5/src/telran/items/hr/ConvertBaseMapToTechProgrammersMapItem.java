package telran.items.hr;

import telran.employees.service.IProgrammer;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class ConvertBaseMapToTechProgrammersMapItem extends CompanyItem {

	public ConvertBaseMapToTechProgrammersMapItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "See list of programmers by technologies";
	}

	@Override
	public void perform() {
		
		io.outputLine(company.convertBaseMapToTechProgrammersMap());
		
	}

}
