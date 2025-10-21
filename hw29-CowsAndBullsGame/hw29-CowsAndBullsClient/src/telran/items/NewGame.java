package telran.items;

import java.util.Map;

import telran.service.Game;
import telran.utils.Constants;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class NewGame implements Item {

	InputOutput io;
	Game game;

	public NewGame(InputOutput io, Game game) {
		super();
		this.io = io;
		this.game = game;
	}

	public Long createNewGame() {

		Long gameId = game.addIdGame();
		io.outputLine("New game started. ID = " + gameId);

		while (true) {
			String str = io.inputString("Enter 4 not repeated numbers ");
			if (str == null) {
				io.outputLine("Game cancelled.");
				return gameId;
			}

			// Отправляем ввод пользователя на сервер
			Map<String, Integer> score = game.makeMove(gameId, str);

			io.outputLine("Result: " + score.get("bulls") + " bulls, " + score.get("cows") + " cows");

			if (score.getOrDefault("bulls", 0) == Constants.SIZE) {
				io.outputLine("You win! Game ID: " + gameId);
				break;
			}
		}
		return gameId;
	}
//	public Long createNewGame() {
//		// Game game = new Game();
//		Long gameId = gameManager.createIdGame();
//		Game game = new Game();
//
//		while (!game.isStopGame()) {
//
//			String str = io.inputString("Enter 4 not repeated numbers ");
//			List<Integer> numberUser = game.getUserNumber(str);
//			List<String> protocol = game.getProtocol();
//			Map<String, Integer> score = game.makeMove(numberUser);
//
//			String record = "Move " + protocol.size() + ": " + numberUser + " " + score;
//			gameManager.makeMove(gameId, record);
//
//			io.outputLine(protocol);
//			io.outputLine(score);
//
//			if (game.isStopGame()) {
//				io.outputLine("You win! Game ID: " + gameId);
//			}
//		}
//		return gameId;
//	}

}
