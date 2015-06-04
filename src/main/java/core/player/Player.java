package core.player;

import java.util.ArrayList;

import core.game.Card;

public interface Player {
	
	public Card play(int color, int value);

	public void addCard(ArrayList<Card> cards);
	public void removeCard(Card card);
	
	public void displayHand();
	
	public String getName();
	public void setName(String name);
	
	public ArrayList<Card> getHand();
	public void setHand(ArrayList<Card>  hand);

	public int getScore();
	public void setScore(int score);
	
	public int getId();
	public void setId(int id);
	
}
