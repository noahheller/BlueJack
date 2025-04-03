package software.enginer.bluejack;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
  private final List<Card> cards;
  private final String name;

  public Player(String name) {
    this.name = name;
    this.cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void removeCard(Card card) {
    cards.remove(card);
  }

  public void clear() {
    cards.clear();
  }

  public String getName() {
    return name;
  }

  public String enumerateHand() {
    String str = "";
    for (int i = 0; i < cards.size(); i++) {
      Card c = cards.get(i);
      str += c.getNumber() + " of " + c.getSuit() + "S";
      if (i < cards.size() - 1) {
        str += ", ";
      }
    }
    return str;
  }

  private int getAcedPoints(int aceValue) {
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

  public int getMinPoints() {
    return getAcedPoints(1);
  }

  public int getMaxPoints() {
    return getAcedPoints(11);
  }

  public int getPoints() {
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

  public abstract boolean shouldDraw();
}
