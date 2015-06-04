package core.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import main.Constant;

public class PackageImpl implements Package {

	ArrayList<Card> pack, cards;
	Game game;
	
	/**
	 * Génère un paquet de carte.
	 * 
	 * @param game
	 */
	public PackageImpl(Game game) {
		
		this.game = game;
		this.cards = new ArrayList<Card>(game.getNbCards()); // ensemble des cartes
		this.pack = new ArrayList<Card>(game.getNbCards()); // gestion du paquet
		
		this.initialize();
		this.shuffle();
	}
	
	@Override
	public void initialize(){
		
		for(int i = 0; i < (game.getNbCards() / 4); i++){
			
			for(int j = 0; j < 4; j++){
				cards.add( new Card(i+this.game.getFirstCard(), j));
			}
		}
		
		pack = cards;
		setPoints();
	}
	
	
	@Override
	public void defineAsset(Card asset) {

		switch (game.getName()) 
		{ 
			case "belote" : 
				for (Card card : cards) {
					
					if(card.getColor() == asset.getColor()){
						card.setAsset(true);
					}
				};
				break;
		}
	}
	
	@Override
	public void defineAsset(int assetColor){
		switch (game.getName()) 
		{ 
			case "belote" : 
				for (Card card : cards) {
					
					if(card.getColor() == assetColor){
						card.setAsset(true);
					}
				};
				break;
		}
	}
	
	@Override
	public void setPoints() {
		switch (game.getName()) 
		{ 
			case "belote" : 
				for (Card card : cards) {
					
					if(card.isAsset()){
						card.setPoint(Constant.BELOTEASSETPOINTS.get(card.getValue()+""));
					}
					else {
						card.setPoint(Constant.BELOTEPOINTS.get(card.getValue()+""));
					}
				};
				break;
		}
	}

	@Override
	public  void shuffle(){
		Collections.shuffle(pack);
	}

	/**
	 * Coupe aléatoire du paquet en 2.
	 */
	@Override
	public void cut(){
		
		ArrayList<Card> newPack = new ArrayList<Card>(this.game.getNbCards());
		
		Random rand = new Random();
		int coupe = rand.nextInt(game.getNbCards()-6) + 3;
		
		for(int i=0; i< game.getNbCards(); i++){
			newPack.add(pack.get((i+coupe)%game.getNbCards()));
		}
		this.pack = newPack;
	}
	
	/**
	 * Distribue des cartes
	 * 
	 * @param nbCards nombre de cartes à distribuer.
	 */
	@Override
	public ArrayList<Card> distribute(int nbCards){
		
		ArrayList<Card> distribution = new ArrayList<Card>(nbCards);
		for(int i=0; i < nbCards; i++){
			distribution.add(pack.get(0));
			pack.remove(0);
		}
		return distribution;
	}


	@Override
	public void addCards(ArrayList<Card> cards) {
		pack.addAll(cards);
	}

	@Override
	public void addCard(Card card) {
		pack.add(card);
	}

	@Override
	public ArrayList<Card> getPack() {
		return pack;
	}

	@Override
	public void setPack(ArrayList<Card> pack) {
		this.pack = pack;
	}
	
}
