package software.enginer.bluejack;

import java.util.List;

public class BlueJack implements Game {

  @Override
  public void initilizeHands(Deck deck, List<Player> players) {
    for (Player player : players) {
      Card card1 = deck.drawCard();
      Card card2 = deck.drawCard();
      player.addCard(card1);
      player.addCard(card2);
    }
  }

  @Override
  public void playRound(Deck deck, List<Player> players) {
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

  @Override
  public void scoreRound(Deck deck, List<Player> players) {
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
