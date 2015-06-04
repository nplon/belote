package core.game;

import core.player.Player;

public interface Team {

	public void addPlayer(Player player);
	public void addScore(int score);
	public int getScore();
}
