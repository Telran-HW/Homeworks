package telran.net;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RequestJava implements Serializable {
	
	//requestType - тип запроса (например, "getUser", "addProduct", "login", и т.д.);
	//requestData — данные, нужные для запроса (например, ID пользователя или объект с информацией).
	
	//Почему Serializable:
	//Чтобы можно было отправлять этот объект по сети — Java должна его сериализовать (превратить в поток байтов).
	
	public String requestType;
	public Serializable requestData;
	
	public RequestJava(String requestType, Serializable requestData) {
		super();
		this.requestType = requestType;
		this.requestData = requestData;
	}

}
