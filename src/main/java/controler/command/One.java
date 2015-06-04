package controler.command;

import controler.Command;
import controler.ui.UiControlerBelote;

public class One implements Command {
	
	UiControlerBelote controler;
	
	public One(UiControlerBelote controler) {

		this.controler = controler;
	}

	@Override
	public void execute() {
		controler.skip(1);
		
	}

}
