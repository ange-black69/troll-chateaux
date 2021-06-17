package Entities;

import Strategies.IStrategy;
import common.Game;
import common.GameState;

public class Player extends Case {
    int stockPierre;
    short playerNumber;
    //Ref to the game
    Game game;
    private IStrategy playerStrategy;

    public Player(int stockPierre, int position, short playerNumber, Game game) {
        super(position);
        game.getChemin().getCasesList()[position] = this;
        this.stockPierre = stockPierre;
        this.playerNumber = playerNumber;
        this.game = game;

    }


    public int getStockPierre() {
        return stockPierre;
    }

    public void setStockPierre(int stockPierre) {
        this.stockPierre = stockPierre;
    }


    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return "Player{" +
                "stockPierre=" + stockPierre +
                ", posCase=" + getIndice() +
                ", playerNumber=" + playerNumber +
                ", game=" + game +
                ", playerStrategy=" + playerStrategy +
                '}';

    }

    public IStrategy getPlayerStrategy() {
        return this.playerStrategy;
    }

    public void setPlayerStrategy(IStrategy strategy) {
        this.playerStrategy = strategy;
        System.out.println("le joueur " + playerNumber + " a maintenant la stratégie : " + this.playerStrategy);
    }

    public int applyStrategy() {
        return this.playerStrategy.apply(this);
    }

    /**
     * lance ou des pierres
     *
     * @param nombreDePierres
     * @return True si le joueur a pu les lancer; False sinon
     */
    public boolean lancerPierres(int nombreDePierres) {
        if (game.getGameState() == GameState.BEGIN) {

            if (stockPierre <= 0) {
                if (playerNumber == 1) {
                    game.setGameState(GameState.PLAYER_ONE_NO_MORE_ROCKS);
                    return false;
                } else if (playerNumber == 2) {
                    game.setGameState(GameState.PLAYER_TWO_NO_MORE_ROCKS);
                    return false;
                }
                return false;

            }
            if (stockPierre < nombreDePierres) {
                System.out.println(toString() + " stock de pierre Insufisant !");
                return false;
            }

            stockPierre -= nombreDePierres;
            System.out.println(toString() + " a lancé " + nombreDePierres + " pierres ! ");
            return true;
        }
        return false;
    }
}
