package telran.net;

import java.io.Serializable;

import telran.dto.AddMove;
import telran.net.server.ProtocolJava;
import telran.service.Game;
import telran.utils.GameApiConstants;

public class GameServerProtocol implements ProtocolJava {

	Game game;

	public GameServerProtocol(Game game) {
		super();
		this.game = game;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		Serializable data = request.requestData;
		
		switch (request.requestType) {
		case GameApiConstants.ADD_ID_GAME:
			try{
				return new ResponseJava(
				TcpResponseCode.OK, 
				game.addIdGame());
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
			
		case GameApiConstants.MAKE_MOVE:{
			AddMove dataMove = (AddMove) data;
			try{
				return new ResponseJava(
				TcpResponseCode.OK, 
				(Serializable) game.makeMove(
						dataMove.getId(), 
						dataMove.getMoveRes()));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		}
		case GameApiConstants.GET_HISTORY:
			try{
				return new ResponseJava(
				TcpResponseCode.OK, 
				(Serializable) game.getResults((Long) data));
			} catch (Exception e) {
				return new ResponseJava(
						TcpResponseCode.WRONG_REQUEST, 
						e.getMessage());
			}
		default:
			return new ResponseJava(
					TcpResponseCode.WRONG_REQUEST, 
					null);
		}
			
	}

}

