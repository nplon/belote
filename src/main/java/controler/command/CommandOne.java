package controler.command;

import controler.ui.UiControlerBelote;

public class CommandOne implements Command {
	
	UiControlerBelote controler;
	
	public CommandOne(UiControlerBelote controler) {

		this.controler = controler;
	}

	@Override
	public void execute() {
		controler.skip(1);
		
	}

}
