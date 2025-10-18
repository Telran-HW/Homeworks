package telran;

import java.io.File;

import telran.employees.net.CompanyServerProtocol;
import telran.employees.service.ProgrammerMap;
import telran.net.server.ProtocolJava;
import telran.net.server.ServerJava;

public class CompanyServerAppl {

	public static void main(String[] args) {
		
		//для восстановления из файла
		ProgrammerMap programmers;
		File file = new File("programmers.data");
		
		if(file.exists()){
		    programmers = ProgrammerMap.restoreFromFile("programmers.data");
		} else {
		    programmers = new ProgrammerMap();
		}
		
		ProtocolJava companyProtocol =  new CompanyServerProtocol(programmers);
		
		ServerJava server;
		try {
			server = new ServerJava(2000, companyProtocol);
			server.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
