package core.player;

import java.util.ArrayList;

import main.Constant;

import org.apache.log4j.Logger;

import core.game.Card;

/**
 * Joueur de carte
 * 
 * @author npillon
 * @date 2012/04
 *
 */
public class PlayerImpl implements Player {

	private static Logger logger = Logger.getLogger(PlayerImpl.class);
	private int id;
	private String name;
	private int score;
	private ArrayList<Card> hand;
	
	public PlayerImpl(int id, String name){
		this.id = id;
		this.name = name;
		this.hand = new  ArrayList<Card>();
	}

	/**
	 * Action de jouer une carte
	 */
	@Override
	public Card play(int color, int value) {
		
		for (Card c : hand) {
			if (c.getId().equals(value + "-" + color)) return c;
		}
		
		return null;
	}
	
	/**
	 * Ajout de cartes dans la main du joueur.
	 */
	@Override
	public void addCard(ArrayList<Card> cards) {
		this.hand.addAll(cards);
	}

	@Override
	public void removeCard(Card card) {
		this.hand.remove(card);
	}
	/**
	 * Affiche la main en console
	 */
	@Override
	public void displayHand(){
		
		logger.debug(" == Main de : " + this.name + " ==");
		for (Card card : hand) {
			logger.debug(Constant.LABELS.get(card.getColor() + "-"  + card.getValue()) + " (" + card.getPoint() + ")");
		};
	}
	
	
	/**
	 * @return le nom du joueur
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name le nom du joueur
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  @return le score
	 */
	@Override
	public int getScore() {
		return score;
	}
	
	/**
	 * @param le score du joueur.
	 */
	@Override
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * @return les cartes du joueur.
	 */
	@Override
	public ArrayList<Card> getHand() {
		return hand;
	}

	/**
	 * @param les cartes du joueur.
	 */
	@Override
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

}
