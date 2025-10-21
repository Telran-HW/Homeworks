package telran.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import telran.dto.AddMove;
import telran.net.TcpClientJava;
import telran.service.Game;
import telran.utils.GameApiConstants;

public class GameProxy extends TcpClientJava implements Game  {

	public GameProxy(String hostname, int port) throws Exception {
		super(hostname, port);
		System.out.println("Proxy created");
	}
	@Override
	public Long addIdGame() {
		try {
			return sendRequest(
					GameApiConstants.ADD_ID_GAME, 
					null);
		} catch (Exception e) {
			System.out.println("addIdGame failed: " + e.getMessage());
			return 0L;
		}
	}
	@Override
	public Map<String, Integer> makeMove(Long gameId, String moveResult) {
		try {
			return sendRequest(
					GameApiConstants.MAKE_MOVE, 
					new AddMove(gameId, moveResult));
		} catch (Exception e) {
			System.out.println("makeMove failed: " + e.getMessage());
			return new HashMap<>();
		}
	}
	@Override
	public List<String> getResults(Long gameId) {
		try {
			return sendRequest(
					GameApiConstants.GET_HISTORY, 
					gameId);
		} catch (Exception e) {
			 System.out.println("getResults failed: " + e.getMessage());
			return new ArrayList<>();
		}
	}


}
