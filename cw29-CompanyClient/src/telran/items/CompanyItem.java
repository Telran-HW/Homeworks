package telran.items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import telran.employees.api.IProgrammer;
import telran.employees.utils.Config;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class CompanyItem implements Item {

	protected InputOutput io;
	protected IProgrammer company;

	public CompanyItem(InputOutput io, IProgrammer company) {
		super();
		this.io = io;
		this.company = company;
	}

	protected Integer getAndCheckExistsProgrammerId() {
		Integer id = io.inputInteger("Enter programmer id ", Config.MIN_ID, Config.MAX_ID);
		if (id == null) {
			io.outputLine("Programmer not found");
		} else {
			if (company.getProgrammerData(id) == null)
				id = null;
			else
				io.outputLine("Programmer exists");
		}
		return id;
	}

	protected Integer getAndCheckNotExistsProgrammerId() {
		Integer id = io.inputInteger("Enter programmer id ", Config.MIN_ID, Config.MAX_ID);
		if (id == null) {
			io.outputLine("Programmer not found");
		} else {
			if (company.getProgrammerData(id) != null)
				id = null;
			else
				io.outputLine("Programmer was added");
		}
		return id;
	}

	protected ArrayList<String> getListTechnilogiesForAdded(Integer id) {
		Set<String> techProg = company.getProgrammerData(id).getTechnologies();

		Set<String> temp = new HashSet<String>(Config.TECHNOLOGY_LIST);
		temp.removeAll(techProg);

		return new ArrayList<String>(temp);
	}

	protected int getSalary(Integer id) {
		int salary = company.getProgrammerData(id).getSalary();
		return salary;
	}
}
