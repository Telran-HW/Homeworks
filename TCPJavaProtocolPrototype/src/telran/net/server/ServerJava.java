package telran.net.server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable {
	
	//Что делает:
	//Это главный сервер, который слушает определённый порт (например, 5000).
	//Принимает новых клиентов (serverSocket.accept()).
	//Для каждого создаёт ServerClientJava.
	
	int port;
	ProtocolJava protocol;
	ServerSocket serverSocket;

	public ServerJava(int port, ProtocolJava protocol) throws Exception {
		super();
		this.port = port;
		this.protocol = protocol;
		this.serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		
		System.out.println("Server runs at port " + port);
		
		try {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				ServerClientJava worker = new ServerClientJava(clientSocket, protocol);
				worker.run();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
