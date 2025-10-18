 package telran.employees.net;

import java.io.Serializable;

import telran.employees.api.IProgrammer;
import telran.employees.api.ProgrammerApiConstants;
import telran.employees.dto.Programmer;
import telran.employees.dto.SalaryFromTo;
import telran.employees.dto.SalaryId;
import telran.employees.dto.TechnologyId;
import telran.employees.utils.Config;
import telran.employees.utils.IPersistable;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponseCode;
import telran.net.server.ProtocolJava;

public class CompanyServerProtocol implements ProtocolJava {
	
	IProgrammer service;

	public CompanyServerProtocol(IProgrammer service) {
		super(); 
		this.service = service;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		Serializable data = request.requestData;
		
		switch (request.requestType) {
		case ProgrammerApiConstants.ADD_PROGRAMMER: {
			try { 
				return new ResponseJava(
						TcpResponseCode.OK, 
						service.addProgrammer((Programmer) data));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		}
		case ProgrammerApiConstants.REMOVE_PROGRAMMER: {
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						service.removeProgrammer((int) data));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		} 
		case ProgrammerApiConstants.GET_PROGRAMMER_BY_ID: {
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						service.getProgrammerData((int) data));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		} 
		case ProgrammerApiConstants.ADD_NEW_TECHNOLOGY: {
			TechnologyId methodData = (TechnologyId) data;
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						service.addNewTechnology(
								methodData.getId(), 
								methodData.getTechnology()));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		}
		case ProgrammerApiConstants.REMOVE_TECHNOLOGY: {
			TechnologyId methodData = (TechnologyId) data;
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						service.removeTechnology(
								methodData.getId(), 
								methodData.getTechnology()));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		}
		case ProgrammerApiConstants.URDATE_SALARY: {
			SalaryId salaryData = (SalaryId) data;
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						service.updateSalary(
								salaryData.getId(), 
								salaryData.getSalary()));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		}
		case ProgrammerApiConstants.GET_PROGRAMMERS_WITH_TECHNOLOGY: {
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						(Serializable) service.getProgrammersWithTechnology((String) data));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		} 
		case ProgrammerApiConstants.GET_PROGRAMMERS_WITH_SALARY: {
			SalaryFromTo fromToData = (SalaryFromTo) data;
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						(Serializable) service.getProgrammersWithSalaries(
								fromToData.getFrom(), 
								fromToData.getTo()));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		} 
		case ProgrammerApiConstants.CONVERT_BASE_MAP_TO_TECH_PROGRAMMERS_MAP: {
			try {
				return new ResponseJava(
						TcpResponseCode.OK, 
						(Serializable) service.convertBaseMapToTechProgrammersMap());
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		} 
		
		case ProgrammerApiConstants.SAVE_PROGRAMMERS: {
			try {
				//((IPersistable) service).save(Config.FILE_NAME);
				if (service instanceof IPersistable persistable) {
				    persistable.save(Config.FILE_NAME);
				} else {
				    return new ResponseJava(TcpResponseCode.WRONG_REQUEST, "Service is not persistable");
				}
				return new ResponseJava(
						TcpResponseCode.OK, 
						true);
			}catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		}
		
		default:
			return new ResponseJava(
					TcpResponseCode.WRONG_REQUEST, 
					null);
		}
	}

}
