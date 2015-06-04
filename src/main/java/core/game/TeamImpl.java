package core.game;

import java.util.ArrayList;

import core.player.Player;

public class TeamImpl implements Team {

	private ArrayList<Player> players;

	private int score;
	
	public TeamImpl() {
		players = new ArrayList<Player>();
		score = 0;
	}
	
	@Override
	public void addPlayer(Player player){
		players.add(player);
	}
	
	@Override
	public void addScore(int score){
		this.score += score;
	}
	
	@Override
	public int getScore(){
		return this.score;
	}

}
