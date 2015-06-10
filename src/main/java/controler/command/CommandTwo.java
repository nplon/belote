package controler.command;

import controler.ui.UiControlerBelote;

public class CommandTwo implements Command {
	
	UiControlerBelote controler;
	
	public CommandTwo(UiControlerBelote controler) {

		this.controler = controler;
	}

	@Override
	public void execute() {
		controler.skip(2);
	}

}
