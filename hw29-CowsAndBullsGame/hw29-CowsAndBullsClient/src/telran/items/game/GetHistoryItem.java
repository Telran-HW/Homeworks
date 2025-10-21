package telran.items.game;

import java.util.List;

import telran.service.Game;
import telran.view.InputOutput;
import telran.view.Item;

public class GetHistoryItem implements Item {
	
	private InputOutput io;
	private Game game;

	public GetHistoryItem(InputOutput io, Game game) {
		this.io = io;
		this.game = game;
	}

	@Override
	public String displayedName() {
		return "Show game history";
	}

	@Override
	public void perform() {
		
		Long id = io.inputLong("Enter game ID: ");
		List<String> results = game.getResults(id);
		
		if (results.isEmpty()) {
			io.outputLine("No results for game " + id);
		} else {
			io.outputLine("Results for game " + id + ":");
			results.forEach(io::outputLine);
		}
	}
}