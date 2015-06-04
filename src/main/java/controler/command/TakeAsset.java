package controler.command;

import controler.Command;
import controler.ui.UiControlerBelote;

public class TakeAsset implements Command {

	private UiControlerBelote controler;
	private int assetColor;
	
	public TakeAsset(UiControlerBelote controler, int assetColor) {
		this.controler = controler;
		this.assetColor = assetColor;
	}

	@Override
	public void execute() {
		controler.distributAsset(assetColor);
	}
}
