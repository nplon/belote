package core.game.belote;

import java.util.HashMap;
import java.util.Map.Entry;

import core.game.Card;
import core.player.Player;

public class Turn {

	private HashMap<Integer, Card> playedCard; // Cartes du pli
	private Player player; // Joueur remportant le pli
	private boolean tenAdditional; // true = +10
	
	public Turn() {
		this.playedCard = new HashMap<Integer, Card>(4);
		this.tenAdditional = false;
	}
	
	/**
	 * Ajoute une carte au pli.
	 * 
	 * @param card Carte à ajouter
	 * @param player Joueur jouant la carte
	 */
	public void add(Card card, Player player){
		playedCard.put(player.getId(), card);
	}

	/**
	 * @return player Gagnant du tour.
	 */
	public Player defineTurnPlayerWinner(){
		
		//TO DO
		
		return player;
	}
	
	/**
	 * @return score Score du pli
	 */
	public int calculateScore(){
		
		int score = 0;
		
		for(Entry<Integer, Card> entry : playedCard.entrySet()) {
		    score += entry.getValue().getPoint();
		}
		
		return score;
	}
	
	
	public HashMap<Integer, Card> getPlayedCard() {
		return playedCard;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isTenAdditional() {
		return tenAdditional;
	}

	public void setTenAdditional(boolean tenAdditional) {
		this.tenAdditional = tenAdditional;
	}
}
