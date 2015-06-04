package core.player.belote;

import java.util.ArrayList;
import java.util.List;

import core.game.Card;
import core.player.Player;

public interface PlayerBelote extends Player {


	public boolean isTaker();
	public void setTaker(boolean taker);
	
	public List<Card> sortHand(ArrayList<Card> hand);
	
	

}
