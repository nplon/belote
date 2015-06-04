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
	 * Réinitialise le tour.
	 */
	public void resetTurns(){
		this.turns = new ArrayList<Turn>();
	}
	
	/**
	 * Attribue un tour à une équipe
	 */
	public void addTurn(Turn turn){
		this.turns.add(turn);
	}
	
	/**
	 * @return score Le score de la manche acquise par l'équipe.
	 */
	public int returnScore(){
		
		int score = 0;
		
		for (Turn turn : this.turns) {
			
			//TODO
			
		}
		
		return score;
	}
}
