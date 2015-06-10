package controler.command;

import controler.ui.UiControlerBelote;

public class CommandTakeAsset implements Command {

	private UiControlerBelote controler;
	private int assetColor;
	
	public CommandTakeAsset(UiControlerBelote controler, int assetColor) {
		this.controler = controler;
		this.assetColor = assetColor;
	}

	@Override
	public void execute() {
		controler.distributAsset(assetColor);
	}
}
