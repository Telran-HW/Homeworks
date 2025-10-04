package telran.view;

public class ItemWithSubmenu implements Item {

	String displayedName;
	Item[] items;
	InputOutput io;
	
	public ItemWithSubmenu(String displayedName, Item[] items, InputOutput io) {
		super();
		this.displayedName = displayedName;
		this.items = items;
		this.io = io;
	}

	@Override
	public String displayedName() {
		return displayedName;
	}

	@Override
	public void perform() {
		Menu menu = new Menu(items,io);
		menu.runMenu();
	}
	
}
