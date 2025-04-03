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
    int largestScore = getPoints(largestScorer.getReadOnlyCards());
    System.out.println("Player: " + largestScorer.getName() + " Scored " + largestScore + " Points");
    for (int i = 1; i < players.size(); i++) {
      Player scorer = players.get(i);
      int points = getPoints(scorer.getReadOnlyCards());
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

  private static int getAcedPoints(List<Card> cards, int aceValue) {
    int points = 0;
    for (Card card : cards) {
      if (card.getNumber() == 1) {
        points += aceValue;
      } else {
        points += card.getNumber();
      }
    }
    return points;
  }

  public static int getMinPoints(List<Card> cards) {
    return getAcedPoints(cards, 1);
  }

  public static int getMaxPoints(List<Card> cards) {
    return getAcedPoints(cards, 11);
  }

  public static int getPoints(List<Card> cards) {
    int points = 0;
    int numberOfAces = 0;
    for (Card card : cards) {
      if (card.getNumber() == 1) {
        numberOfAces++;
        points += 11;
      } else {
        points += card.getNumber();
      }
    }
    while (numberOfAces > 0 && points > 21) {
      points -= 10;
      numberOfAces--;
    }
    return points;
  }
}
