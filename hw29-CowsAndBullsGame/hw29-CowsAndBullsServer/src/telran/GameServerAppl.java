package telran;

import telran.net.GameServerProtocol;
import telran.net.server.ProtocolJava;
import telran.net.server.ServerJava;
import telran.service.GameImpl;

public class GameServerAppl {

	public static void main(String[] args) {
		
		ServerJava server;
		ProtocolJava gameProtocol = new GameServerProtocol(new GameImpl());
		
		try {
			server = new ServerJava(2000, gameProtocol);
			server.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
