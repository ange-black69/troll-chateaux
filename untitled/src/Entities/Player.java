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
        return this.playerStrategy.apply(game,this, false);
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
                    handlePlayer1NoMoreRocks(game.getJoueur1(), game.getJoueur2(), game);
                    return false;
                } else if (playerNumber == 2) {
                    handlePlayer2NoMoreRocks(game.getJoueur1(), game.getJoueur2(), game);
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


    /**
     * simule le lancer des pierres sans en détériorer le stock
     *
     * @param nombreDePierres
     * @return True si le joueur a pu les lancer; False sinon
     */
    public boolean simulateLancerPierres(int nombreDePierres) {
        if (game.getGameState() == GameState.BEGIN) {

            if (stockPierre < nombreDePierres) {
                System.out.println(toString() + " stock de pierre Insufisant !");
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Fonction permettant de gérer le cas ou le joueur 1 n'a plus de pierre.
     * On va appliquer ce que nous dit le sujet : on deplace le troll le nombre de fois qu'il reste de pierres aux
     * joueur 2
     * @param p1 Player
     * @param p2 Player
     */
    public static void handlePlayer1NoMoreRocks(Player p1, Player p2, Game game)
    {
        System.out.println("[Player] La partie est terminée car le joueur 1 n'a plus de pierre !");
        System.out.println("[Player] le joueur 2 possède encore " + p2.getStockPierre() + "pierres ");
        System.out.println("[Player] le troll bouge donc de " + p2.getStockPierre()
                + " cases en direction du joueur 1 !");

        // On déplace le troll d'autant de pierre(s) qu'il reste au joueur 2
        for(int i = 0; i < p2.getStockPierre(); i++)
        {
            game.getTroll().deplacerVersJoueur1();
        }

                /*
                Si le troll n'a pas atteint le chateau d'un des joueurs, on calcule la distance entre le troll et le
                chateau
                 */
        int trollPos = game.getTroll().getIndice();
        int playerOnePos = p1.getIndice();
        int playerTwopos = p2.getIndice();

        // Le troll est a la meme distance des deux joueurs, match nul !
        if((Math.abs(trollPos - playerOnePos)) == Math.abs(trollPos - playerTwopos))
        {
            game.setGameState(GameState.DRAW);
        }
        // Le troll est plus proche du joueur 1 !
        else if((Math.abs(trollPos - playerOnePos)) < Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 2 gagne !
            game.setGameState(GameState.PLAYER_TWO_WIN);
        }
        // Le troll est plus proche du joueur 2 !
        else if ((Math.abs(trollPos - playerOnePos)) > Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 1 gagne !
            game.setGameState(GameState.PLAYER_ONE_WIN);

        }
    }
    /**
     * Fonction permettant de gérer le cas ou le joueur 2 n'a plus de pierre.
     * On va appliquer ce que nous dit le sujet : on deplace le troll le nombre de fois qu'il reste de pierres aux
     * joueur 1
     * @param p1 : Player
     * @param p2 : Player
     */
    public static void handlePlayer2NoMoreRocks(Player p1, Player p2, Game game)
    {
        System.out.println("[Player] La partie est terminée car le joueur 2 n'a plus de pierre !");
        System.out.println("[Player] le joueur 1 possède encore " + p1.getStockPierre() + "pierres ");
        System.out.println("[Player] le troll bouge donc de " + p1.getStockPierre()
                + " cases en direction du joueur 2 !");

        // On déplace le troll d'autant de pierre(s) qu'il reste au joueur 1
        for(int i = 0; i < p1.getStockPierre(); i++)
        {
            game.getTroll().deplacerVersJoueur2();
        }

                /*
                Si le troll n'a pas atteint le chateau d'un des joueurs, on calcule la distance entre le troll et le
                chateau
                 */
        int trollPos = game.getTroll().getIndice();
        int playerOnePos = p1.getIndice();
        int playerTwopos = p2.getIndice();

        // Le troll est a la meme distance des deux joueurs, match nul !
        if((Math.abs(trollPos - playerOnePos)) == Math.abs(trollPos - playerTwopos))
        {
            game.setGameState(GameState.DRAW);
        }
        // Le troll est plus proche du joueur 1 !
        else if((Math.abs(trollPos - playerOnePos)) < Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 2 gagne !
            game.setGameState(GameState.PLAYER_TWO_WIN);
        }
        // Le troll est plus proche du joueur 2 !
        else if ((Math.abs(trollPos - playerOnePos)) > Math.abs(trollPos - playerTwopos))
        {
            // Le joueur 1 gagne !
            game.setGameState(GameState.PLAYER_ONE_WIN);

        }
    }

    public short getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(short playerNumber) {
        this.playerNumber = playerNumber;
    }
}
