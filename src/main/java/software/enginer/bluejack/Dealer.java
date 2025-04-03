package software.enginer.bluejack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer {
  public static final Scanner scanner = new Scanner(System.in);
  private final Deck deck;
  private final List<Player> players;
  private Game game;

  public Dealer(Game game) {
    deck = new Deck();
    players = new ArrayList<>();
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void play() {
    game.initilizeHands(deck, players);
    game.playRound(deck, players);
    game.scoreRound(deck, players);
  }
}
