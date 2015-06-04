package controler.command;

import controler.Command;
import controler.ui.UiControlerBelote;
import core.game.Card;

public class Play implements Command{

	private UiControlerBelote controler;
	private int player;
	private Card card;
	
	public Play(UiControlerBelote controler, Card card, int player) {
		this.controler = controler;
		this.player = player;
		this.card = card;
	}
	
	@Override
	public void execute() {
		controler.play(card, player);
	}
}
