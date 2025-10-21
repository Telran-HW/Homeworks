package telran;

import java.io.File;

import telran.employees.net.CompanyServerProtocol;
import telran.employees.service.ProgrammerMap;
import telran.employees.utils.Config;
import telran.employees.utils.IPersistable;
import telran.net.server.ProtocolJava;
import telran.net.server.ServerJava;

public class CompanyServerAppl {

	public static void main(String[] args) {
		
		//для восстановления из файла
		ProgrammerMap programmers;
		File file = new File(Config.FILE_NAME);
		ServerJava server;
		
		if(file.exists()){
		    programmers = ProgrammerMap.restoreFromFile(Config.FILE_NAME);
		} else {
		    programmers = new ProgrammerMap();
		}
		
		ProtocolJava companyProtocol =  new CompanyServerProtocol(programmers);
		//ProtocolJava companyProtocol =  new CompanyServerProtocol(new ProgrammerMap());
	
		try {
			server = new ServerJava(2000, companyProtocol);
			server.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			((IPersistable)programmers).save(Config.FILE_NAME);
		}
		
		
	}

}
