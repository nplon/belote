package controler.command;

import controler.Command;
import controler.ui.UiControlerBelote;

public class Two implements Command {
	
	UiControlerBelote controler;
	
	public Two(UiControlerBelote controler) {

		this.controler = controler;
	}

	@Override
	public void execute() {
		controler.skip(2);
	}

}
