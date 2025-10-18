package telran.items.hr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import telran.employees.api.IProgrammer;
import telran.employees.utils.Config;
import telran.items.CompanyItem;
import telran.view.InputOutput;

public class AddNewTechnologyItem extends CompanyItem{

	public AddNewTechnologyItem(InputOutput io, IProgrammer company) {
		super(io, company);
	}

	@Override
	public String displayedName() {
		return "Add new technology";
	}

	@Override
	public void perform() {
		
		Integer id = getAndCheckExistsProgrammerId();
		if(id == null) return;
		
		
		ArrayList<String> techProg = getListTechnilogiesForAdded(id);
		
		String technology = io.inputString("Enter name of technology from list: " + techProg + " ", techProg);
		
		try {
			io.outputLine(company.addNewTechnology(id, technology));
		} catch (Exception e) {
			io.outputLine("Something went wrong! Programmer's technology not added!");
		}
		
	}

}
