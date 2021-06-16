package Entities;

import Strategies.IStrategy;
import common.Game;
import common.Main;

public class Player extends Case
{
    int stockPierre;
    short playerNumber;
    //Ref to the game
    Game game;
    private IStrategy playerStrategy;

    public Player(int stockPierre, int position, short playerNumber, Game game)
    {
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


    public void setPlayerStrategy(IStrategy strategy)
    {
        this.playerStrategy = strategy;
    }

    public IStrategy getPlayerStrategy()
    {
        return this.playerStrategy;
    }

    public int applyStrategy()
    {
        return this.playerStrategy.apply(this);
    }

    public void lancerPierres(int nombreDePierres)
    {
        if(stockPierre < nombreDePierres)
        {
            Main.logger.info(toString() +" stock de pierre Insufisant !");
            return;
        }
        stockPierre -= nombreDePierres;
    }


}
