package core.game.belote;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import controler.ui.UiControlerBelote;
import core.game.Card;
import core.game.GameImpl;
import core.game.PackageImpl;
import core.game.Team;
import core.player.Player;
import core.player.belote.PlayerBelote;
import core.player.belote.PlayerBeloteImpl;

public class Belote extends GameImpl{

	private static Logger logger = Logger.getLogger(Belote.class);
	private UiControlerBelote controler;
	private ArrayList<PlayerBelote> players; 
	private PackageImpl cardPackage;
	private ArrayList<Team> teams;
	private ArrayList<Turn> turns;
	private Card asset; // Atout
	private int currentPlayer; // Joueur courant.
	private int startPlayer; // Joueur débutant la manche
	private int skip;
	private int currentTurn; // Tour de la manche
	
	static private int NBPLAYERS = 4;

	public Belote() {
		super("belote", 32, 7, NBPLAYERS);
		currentPlayer = 0;
		currentTurn = 0;
		startPlayer = 0;
		skip = 1;
		
		initPlayers();
		initBelote();
		initTeam();
		initTurn();
	}
	
	/** 
	 * Initialise une partie de belote
	 */
	private void initBelote(){
		
		initPack();
		initDistribution();
		asset = distributeAsset();
		
		controler = new UiControlerBelote(this);
	}
	
	/**
	 * Initialise une donne
	 */
	private void initHands(){
		
		reinitPack();

		startPlayer = (startPlayer+1)%players.size();
		currentPlayer = startPlayer;
		currentTurn = 0;

		initDistribution();
		asset = distributeAsset();
		
		controler.displayHand();
		controler.displayAsset(asset);
		controler.refreshActionPanel();
		
	}
	
	
	/**
	 * Initialise 4 joueurs de belote.
	 */
	private void initPlayers() {

		players = new ArrayList<PlayerBelote>(NBPLAYERS);
		
		for (int i = 0; i < NBPLAYERS; i++) {
			players.add(new PlayerBeloteImpl(i, "Joueur " + i));
		}
		
		currentPlayer = startPlayer;

	}

	/**
	 * Initialise les �quipes
	 */
	private void initTeam()  {
		
		teams = new ArrayList<Team>(2);
		teams.add(new BeloteTeam());
		teams.add(new BeloteTeam());
		
		teams.get(0).addPlayer(players.get(0));
		teams.get(0).addPlayer(players.get(2));
		
		teams.get(1).addPlayer(players.get(1));
		teams.get(1).addPlayer(players.get(3));
		
	}
	

	/**
	 * Initialise le paquet de carte.
	 */
	public void initPack(){		
		// On initialise un jeu de belote � 32 cartes commen�ant � la carte 7.
		cardPackage = new PackageImpl(this);
		cardPackage.cut();
	}
	
	/**
	 * R�initialise le paquet
	 */
	private void reinitPack(){
		for (PlayerBelote player : players) {
			cardPackage.addCards(player.getHand());
			player.setHand(new  ArrayList<Card>());
		}
		
		for(Turn turn : turns)
		{
			for(Entry<Integer, Card> entry : turn.getPlayedCard().entrySet()) {
			    cardPackage.addCard(entry.getValue());
			}
		}
		
		cardPackage.addCard(asset);
	}
	
	/**
	 * Initialise la distribution des 5 cartes par joueur.
	 */
	private void initDistribution() {
		
		ArrayList<PlayerBelote> sortedPlayers = new ArrayList<PlayerBelote>();
		for (int i = 0; i < 4;i++){
			sortedPlayers.add(players.get((startPlayer + i)%players.size()));
		}
		
		for (Player player : sortedPlayers) {
			player.addCard(cardPackage.distribute(3));
		}
		
		for (Player player : sortedPlayers) {
			player.addCard(cardPackage.distribute(2));
		}
		
		sortHand();
	
	}	
	
	
	/**
	 * Effectue la seconde distribution de cartes.
	 */
	public void finishDistribution(){
		
		ArrayList<PlayerBelote> sortedPlayers = new ArrayList<PlayerBelote>();
		for (int i = 0; i < 4;i++){
			sortedPlayers.add(players.get((startPlayer + i)%players.size()));
		}
		
		for (PlayerBelote player : sortedPlayers) {
			if(player.isTaker()){
				player.getHand().add(asset);
				player.addCard(cardPackage.distribute(2));
			}
			else {
				player.addCard(cardPackage.distribute(3));
			}
		}
		
		sortHand();
		
		controler.displayHand();
	}
	

	/**
	 * Distribue l'atout.
	 * 
	 * @param assetColor Couleur de l'atout
	 */
	public void distributAsset(int assetColor) {
		setAsset(asset);
		setTaker();
		if(skip == 1){
			cardPackage.defineAsset(asset);
		}
		else {
			cardPackage.defineAsset(assetColor);
		}
		
		cardPackage.setPoints();
		finishDistribution();
		currentPlayer = startPlayer;
	}


	
	/**
	 * Trie la main des joueurs
	 */
	public void sortHand(){
		
		for (PlayerBelote player : players) {
			player.setHand((ArrayList<Card>) player.sortHand(player.getHand()));
		}
	}

	/**
	 * Initialise les tours
	 */
	private void initTurn(){
		turns = new ArrayList<Turn>();
		newTurn();
	}
	
	/**
	 * Ajoute un tour de cartes
	 */
	private void newTurn(){
		turns.add(new Turn());
	}
	
	/**
	 * Gestion du tour.
	 */
	public void manageTurn(){

		
		if(currentTurn != 7 && currentPlayer == startPlayer){
			//TODO Définir qui gagne le tour.
			//TODO Attribuer le pli au joueur gagnant
			//TODO Définir le joueur gagnant comme débutant le prochain tour
			
			// Réinitialise un nouveau tour.
			newTurn();
			currentTurn++;
			controler.eraseCenter();
		}
		else if (currentTurn == 7 && currentPlayer == startPlayer){
			//TODO Définir qui gagne le tour.
			//TODO Attribuer le pli au joueur gagnant

			skip = 1;
			
			controler.eraseCenter();
			initHands();
			
		}
	}
	
	/**
	 * Passe au joueur suivant
	 */
	private void nextCurrentPlayer() {
		currentPlayer = (currentPlayer+1)%players.size();		
	}

	
	/**
	 * D�finit le preneur
	 * 
	 * @param player
	 */
	public void setTaker(){
		players.get(currentPlayer).setTaker(true);
	}
	
	
	/**
	 * @return l'atout propos�
	 */
	public Card distributeAsset(){
		
		asset = cardPackage.distribute(1).get(0);
		return asset;
	}

	/**
	 * Action de jouer une carte
	 * 
	 * @param card Carte jou�e
	 * @param player Joueur jouant
	 */
	public void play(Card card, int player) {
		
		if(player == currentPlayer){ 
			if(validatePlayer(card, players.get(player)) && validateCard(card, players.get(player), turns.get(currentTurn))){
				players.get(player).removeCard(card);
				nextCurrentPlayer();
				controler.displayPlayedCard(card, player);
				controler.displayHand();
				turns.get(currentTurn).add(card, players.get(player));
				manageTurn();
			}
		}
	}

	
	
	/**
	 * Valide qu'un joueur a bien la carte mentionn�e.
	 * 
	 * @param card carte
	 * @param player joueur
	 * @return true si le joueur a la carte, false sinon
	 */
	public boolean validatePlayer(Card card, Player player){
		return player.getHand().contains(card);
	}
	
	/**
	 * Valide la carte jouée, par le joueur, pour le tour donn�e
	 * 
	 * @param card Carte jouée
	 * @param player Joueur de la carte
	 * @param turn Tour pour laquelle la carte est jou�e
	 * @return true si la carte est valide, false sinon
	 */
	public boolean validateCard(Card card, Player player, Turn turn){
		
		//TODO Valide la carte jou�e.
		return true;
	}

	/**
	 * Gestion de la "non prise" de l'atout. 
	 * 
	 * @param i 
	 */
	public void skip(int i) {
		nextCurrentPlayer();
		
		if(currentPlayer == startPlayer){

			if(skip==1){
				skip = 2;
			}
			else{
				skip = 1;
				initHands();
			}
		}
	}


	/**
	 * @param num numéro du joueur
	 * @return le joueur correspondant au numéro
	 */
	public PlayerBelote getPlayer(int num) {
		return players.get(num);
	}
	
	
	/**
	 * @return la liste des joueurs.
	 */
	public ArrayList<PlayerBelote> getPlayers() {
		return players;
	}

	/**
	 * @return le joueur courant.
	 */
	public PlayerBelote getCurrentPlayer() {
		return players.get(currentPlayer);
	}


	/**
	 * @param players Liste des joueurs.
	 */
	public void setPlayers(ArrayList<PlayerBelote> players) {
		this.players = players;
	}


	/**
	 * @return l'atout de la manche.
	 */
	public Card getAsset() {
		return asset;
	}


	/**
	 * D�finit l'atout et g�re la m�j des points des cartes.
	 * 
	 * @param asset atout de la manche.
	 */
	public void setAsset(Card asset) {
		this.asset = asset;
	}

	
	/**
	 * D�finit si les joueurs peuvent dire 1 ou 2.
	 * @return skip Ce que peuvent dire les joueurs.
	 */
	public int getSkip() {
		return skip;
	}
	
}
