package telran.items.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import telran.employees.dto.Programmer;
import telran.employees.service.IProgrammer;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class RemoveTechnologyItem extends CompanyItem{

	public RemoveTechnologyItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "Remove technology";
	}

	@Override
	public void perform() {
		
		Integer id = getAndCheckExistsProgrammerId();
		if(id == null) return;
		
		Programmer temp = company.getProgrammerData(id);
		List<String> technologies = new ArrayList<String>(temp.getTechnologies());
		String technology = io.inputString("Enter name of technology from list: " + technologies.toString() + " ", technologies);
		
		io.outputLine(company.removeTechnology(id, technology));
	}

}
