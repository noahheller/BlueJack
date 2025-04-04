package software.enginer.bluejack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

  public final List<Card> cards;

  public Hand() {
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

  @Override
  public String toString() {
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

  public List<Card> getReadOnlyCards() {
    return Collections.unmodifiableList(cards);
  }
}
