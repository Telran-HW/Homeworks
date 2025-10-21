package telran;

import telran.items.game.GetHistoryItem;
import telran.items.game.MoveItem;
import telran.proxy.GameProxy;
import telran.service.Game;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.ItemWithSubmenu;
import telran.view.Menu;

public class GameClientAppl {

	static Game gameManager;
	static InputOutput io;

	public static void main(String[] args) {

		try {
			gameManager = new GameProxy("localhost", 2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		io = new ConsoleInputOutput();

		Item[] items = { 
				new ItemWithSubmenu("Start new game", getGameMenu(), io), 
				new ExitItem() 
				};

		Menu menu = new Menu(items, io);
		menu.runMenu();

	}

	private static Item[] getGameMenu() {
		Item[] items = { 
				new MoveItem(io, gameManager), 
				new GetHistoryItem(io, gameManager), 
				new ExitItem() };
		return items;
	}

}
