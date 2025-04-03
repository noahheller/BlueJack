package software.enginer.bluejack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer {
  public static final Scanner scanner = new Scanner(System.in);
  private final Deck deck;
  private final List<Player> players;

  public Dealer() {
    deck = new Deck();
    players = new ArrayList<>();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void play() {
    initilizeHands();
    playRound();
    scoreRound();
  }

  private void initilizeHands() {
    for (Player player : players) {
      Card card1 = deck.drawCard();
      Card card2 = deck.drawCard();
      player.addCard(card1);
      player.addCard(card2);
    }
  }

  private void playRound() {
    System.out.println("Welcome to bluejack..");
    for (Player player : players) {
      // clear screen
      System.out.print("\033[H\033[2J");
      System.out.flush();

      boolean stillDrawing = true;
      while (stillDrawing) {
        stillDrawing = false;
        System.out.println(player.getName() + " You have a " + player.enumerateHand());
        System.out.println(player.getName() + " Would you like to 'hit' or 'stay'");
        if (player.shouldDraw()) {
          stillDrawing = true;
          Card card = deck.drawCard();
          player.addCard(card);
        }
      }
    }
  }

  private void scoreRound() {
    Player largestScorer = players.get(0);
    int largestScore = largestScorer.getPoints();
    System.out.println("Player: " + largestScorer.getName() + " Scored " + largestScore + " Points");
    for (int i = 1; i < players.size(); i++) {
      Player scorer = players.get(i);
      int points = scorer.getPoints();
      if (points > 21 || largestScore > 21) {
        if (points < largestScore) {
          largestScorer = scorer;
          largestScore = points;
        }
      } else {
        if (points > largestScore) {
          largestScorer = scorer;
          largestScore = points;
        }
      }

      System.out.println("Player: " + scorer.getName() + " Scored " + points + " Points");
    }
    System.out.println(largestScorer.getName() + " WON!");

  }
}
