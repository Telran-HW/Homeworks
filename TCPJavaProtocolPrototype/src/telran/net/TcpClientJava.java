package telran.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class TcpClientJava implements Closeable {
	
	// соединение с сервером
	
	//Что делает:
	//Это клиент, который подключается к серверу и умеет отправлять запросы и получать ответы.
	
	//В конструкторе:
	//создаёт Socket, подключается к серверу (new Socket(hostname, port)),
	//открывает потоки для чтения (input) и записи (output).
	
	//Метод sendRequest:
	//1 Создаёт объект RequestJava с нужным типом запроса и данными.
	//2 Отправляет его на сервер.
	//3 Получает ответ (ResponseJava).
	//4 Проверяет, всё ли прошло успешно (response.code == OK).
	//5 Возвращает данные из ответа.
	
	protected ObjectInputStream input;
	protected ObjectOutputStream output;
	protected Socket socket;
	
	public TcpClientJava(String hostname, int port) throws Exception{
		this.socket = new Socket(hostname, port);
		System.out.println("Client socket created " + this.socket.getPort());
		
		this.output = new ObjectOutputStream(socket.getOutputStream());
		output.flush(); //необязательнге действие
		this.input = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void close() throws IOException {
		socket.close();
	}
	
	@SuppressWarnings("unchecked")
	protected <T>T sendRequest(String requestType, Serializable requestData) throws Exception {
		
		try {
			RequestJava request = new RequestJava(requestType, requestData);
			output.writeObject(request);
			//желательно поставить временные ограничения. Timeout
			
			ResponseJava response = (ResponseJava) input.readObject();
			if(response.code != TcpResponseCode.OK)
				throw new Exception(response.code.toString());
			return (T)response.responseData;
			
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
