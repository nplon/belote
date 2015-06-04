package core.game.belote;

import java.util.ArrayList;

import core.game.TeamImpl;

public class BeloteTeam extends TeamImpl {

	private ArrayList<Turn> turns;
	
	public BeloteTeam() {
		super();
		this.turns = new ArrayList<Turn>();
	}
	
	/**
	 * R�initialise le tour.
	 */
	public void resetTurns(){
		this.turns = new ArrayList<Turn>();
	}
	
	/**
	 * Attribue un tour � une �quipe
	 */
	public void addTurn(Turn turn){
		this.turns.add(turn);
	}
	
	/**
	 * @return score Le score de la manche acquise par l'�quipe.
	 */
	public int returnScore(){
		
		int score = 0;
		
		for (Turn turn : this.turns) {
			
			//TODO
			
		}
		
		return score;
	}
}
