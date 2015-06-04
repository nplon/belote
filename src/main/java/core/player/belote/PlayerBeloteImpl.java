package core.player.belote;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Ordering;

import core.game.Card;
import core.game.CardComparatorColor;
import core.game.CardComparatorPoint;
import core.game.CardComparatorValue;
import core.player.PlayerImpl;

public class PlayerBeloteImpl extends PlayerImpl implements PlayerBelote {

	private boolean taker;

	public PlayerBeloteImpl(int id, String name){
		super(id, name);
		taker = false;
	}

	@Override
	public List<Card> sortHand(ArrayList<Card> hand){
		
		List<Card> sortedHand = Ordering.from(new CardComparatorColor()).compound(new CardComparatorPoint()).compound(new CardComparatorValue()).sortedCopy(hand);
		
		return sortedHand; 
	}
	
	@Override
	public boolean isTaker() {
		return taker;
	}

	@Override
	public void setTaker(boolean taker) {
		this.taker = taker;
	}

}
