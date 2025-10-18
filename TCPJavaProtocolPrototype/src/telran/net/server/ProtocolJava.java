package telran.net.server;

import telran.net.RequestJava;
import telran.net.ResponseJava;

public interface ProtocolJava {
	
	//Это интерфейс, который описывает, как сервер должен обрабатывать запросы.
	
	ResponseJava getResponse(RequestJava request);

}
