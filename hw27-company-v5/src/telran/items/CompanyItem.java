package telran.items;

import telran.employees.service.IProgrammer;
import telran.employees.utils.Config;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class CompanyItem implements Item{
	
	protected InputOutput io;
	protected IProgrammer company;
	
	public CompanyItem(InputOutput io, IProgrammer company) {
		super();
		this.io = io;
		this.company = company;
	}
	
	protected Integer getAndCheckExistsProgrammerId() {
		Integer id = io.inputInteger("Enter programmer id ", Config.MIN_ID, Config.MAX_ID);
		if(id == null) {
			io.outputLine("Programmer not found");
		}
		else {
			if(company.getProgrammerData(id) == null)
				id = null;
			else io.outputLine("Programmer exists");
		}
		return id;
	}
	protected Integer getAndCheckNotExistsProgrammerId() {
		Integer id = io.inputInteger("Enter programmer id ", Config.MIN_ID, Config.MAX_ID);
		if(id == null) {
			io.outputLine("Programmer not found");
		}
		else {
			if(company.getProgrammerData(id) != null)
				id = null;
			else io.outputLine("Programmer was added");
		}
		return id;
	}

}
