package core.game;

import java.util.ArrayList;

public interface Package {


	public void cut();

	public void initialize();
	
	public void defineAsset(Card asset);
	
	public void defineAsset(int assetColor);
	
	public void setPoints();

	public void shuffle();

	public ArrayList<Card> distribute(int nbCards);
	
	public void addCards(ArrayList<Card> cards);
	
	public void addCard(Card card);

	public ArrayList<Card> getPack();

	public void setPack(ArrayList<Card> pack);

	
	
}
