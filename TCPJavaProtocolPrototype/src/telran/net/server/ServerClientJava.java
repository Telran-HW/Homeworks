package telran.net.server;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import telran.net.RequestJava;
import telran.net.ResponseJava;

public class ServerClientJava implements Runnable {
	
	//Что делает:
	//Это "работник" для отдельного клиента.
	//Получает от клиента RequestJava.
	//Передаёт запрос в protocol.getResponse().
	//Отправляет обратно ResponseJava.
	
	//Метод run():
	//Просто цикл: принимает запрос → обрабатывает → отвечает.
	
	ObjectInputStream input;
	ObjectOutputStream output;
	Socket socket;
	ProtocolJava protocol;
	
	public ServerClientJava(Socket socket, ProtocolJava protocol) throws Exception {
		super();
		this.socket = socket;
		this.protocol = protocol;
		
		this.output = new ObjectOutputStream(socket.getOutputStream());
		output.flush(); //необязательнге действие
		this.input = new ObjectInputStream(socket.getInputStream());
	}



	@Override
	public void run() {
		
		
			try {
				while (true) {
				RequestJava request = (RequestJava) input.readObject();
				ResponseJava response = protocol.getResponse(request);
				output.writeObject(response);
				}

			} catch (EOFException e) {
				System.out.println("Connection was closed by client");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		}

	

}
