package controler.ui;

import java.util.ArrayList;

import ui.GameWindow;
import core.game.Card;
import core.game.belote.Belote;
import core.player.belote.PlayerBelote;

public class UiControlerBelote {
	
	private Belote belote;
	private GameWindow window;

	public UiControlerBelote(Belote belote) {
		this.belote = belote;
		this.window = new GameWindow("Belote", this);
		this.window.displayHand();
		this.window.displayAsset(getAsset());
	}

		
	public PlayerBelote getPlayer(int currentPlayer) {
		return belote.getPlayer(currentPlayer);
	}

	public ArrayList<PlayerBelote> getPlayers() {
		return belote.getPlayers();
	}
	
	private Card getAsset() {
		return belote.getAsset();
	}
	
	public Belote getBelote() {
		return belote;
	}
	

	public PlayerBelote getCurrentPlayer() {
		return belote.getCurrentPlayer();
	}
	
	public void play(Card card, int player) {
		belote.play(card, player);
	}

	public void skip(int i){	
		belote.skip(i);
		window.refreshActionPanel();
	}

	public int getSkip(){
		return belote.getSkip();
	}
	
	public void distributAsset(int assetColor) {
		belote.distributAsset(assetColor);
		window.closeAssetManagement();
	}

	// Java -> UI
	public GameWindow getWindow() {
		return window;
	}

	public void displayHand() {
		window.displayHand();
	}

	public void displayAsset(Card asset) {
		window.displayAsset(asset);
	}

	public void displayPlayedCard(Card card, int player){
		window.displayPlayedCard(card, player);
	}

	public void refreshActionPanel() {
		window.refreshActionPanel();
	}


	public void eraseCenter() {
		window.eraseCenter();
	}
}
