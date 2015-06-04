package core.game;


public class GameImpl implements Game {
	
	private String name;
	private int nbCards;
	private int firstCard; // valeur de la première carte du jeu (2 à 14) (as = 14)

	
	public GameImpl(String name, int nbCartes, int  nbPlayer){
		new GameImpl(name, nbCartes, 2, 4);
		
	}
	
	public GameImpl(String name, int nbCards, int firstCard, int  nbPlayer) {
		this.name = name;
		this.nbCards = nbCards;
		
		if(firstCard < 2 || firstCard > 14){
			this.firstCard = 2;
		}
		else{
			this.firstCard = firstCard;
		}
	}
	
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getNbCards() {
		return nbCards;
	}

	@Override
	public void setNbCards(int nbCards) {
		this.nbCards = nbCards;
	}

	@Override
	public int getFirstCard() {
		return firstCard;
	}

	@Override
	public void setFirstCard(int firstCard) {
		this.firstCard = firstCard;
	}

}
