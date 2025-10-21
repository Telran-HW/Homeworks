package telran.items.game;

import telran.items.NewGame;
import telran.service.Game;
import telran.view.InputOutput;

public class MoveItem extends NewGame {

	public MoveItem(InputOutput io, Game gameManager) {
		super(io, gameManager);
	}
	@Override
	public String displayedName() {
		return "Make move";
	}

	@Override
	public void perform() {
		createNewGame();
	}

}
