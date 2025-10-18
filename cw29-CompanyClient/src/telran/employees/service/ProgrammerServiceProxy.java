package telran.employees.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import telran.employees.api.IProgrammer;
import telran.employees.api.ProgrammerApiConstants;
import telran.employees.dto.Programmer;
import telran.employees.dto.SalaryFromTo;
import telran.employees.dto.SalaryId;
import telran.employees.dto.TechnologyId;
import telran.employees.utils.IPersistable;
import telran.net.TcpClientJava;

public class ProgrammerServiceProxy extends TcpClientJava implements IProgrammer, IPersistable {

	public ProgrammerServiceProxy(String hostname, int port) throws Exception {
		super(hostname, port);
		System.out.println("Proxy created");
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {
		try {
			return sendRequest(ProgrammerApiConstants.ADD_PROGRAMMER, programmer);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeProgrammer(int id) {
		try {
			return sendRequest(ProgrammerApiConstants.REMOVE_PROGRAMMER, id);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Programmer getProgrammerData(int id) {
		try {
			return sendRequest(ProgrammerApiConstants.GET_PROGRAMMER_BY_ID, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		try {
			return sendRequest(ProgrammerApiConstants.ADD_NEW_TECHNOLOGY, 
					new TechnologyId(id, technology));
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		try {
			return sendRequest(ProgrammerApiConstants.REMOVE_TECHNOLOGY, 
					new TechnologyId(id, technology));
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		try {
			return sendRequest(ProgrammerApiConstants.GET_PROGRAMMERS_WITH_TECHNOLOGY, technology);
		} catch (Exception e) {
			 System.out.println("Error getting programmers with technology: " + e.getMessage());
		        return new ArrayList<>();
		}
	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		try {
			return sendRequest(ProgrammerApiConstants.GET_PROGRAMMERS_WITH_SALARY, new SalaryFromTo(salaryFrom, salaryTo));
		} catch (Exception e) {
			 System.out.println("Error getting programmers with salary: " + e.getMessage());
		        return new ArrayList<>();
		}
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		try {
			return sendRequest(ProgrammerApiConstants.URDATE_SALARY, 
					new SalaryId(id, salary));
		} catch (Exception e) {
			System.out.println("salary was not updated");
			return false;
		}
	}

	@Override
	public Map<String, Set<Programmer>> convertBaseMapToTechProgrammersMap() {
		try {
	        return sendRequest(ProgrammerApiConstants.CONVERT_BASE_MAP_TO_TECH_PROGRAMMERS_MAP, null);
	    } catch (Exception e) {
	        System.out.println("convert was not done");
	        return new HashMap<String, Set<Programmer>>();
	    }
	}
	

	@Override
	public void save(String fileName) {
		try {
	        sendRequest(ProgrammerApiConstants.SAVE_PROGRAMMERS, null);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
		
	}

}
