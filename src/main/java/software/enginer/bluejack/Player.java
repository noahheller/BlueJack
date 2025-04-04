package software.enginer.bluejack;

import java.util.List;

public abstract class Player {
  private final Hand hand;
  private final String name;

  public Player(String name) {
    this.name = name;
    this.hand = new Hand();
  }

  public void addCard(Card card) {
    hand.addCard(card);
  }

  public void removeCard(Card card) {
    hand.removeCard(card);
  }

  public void clear() {
    hand.clear();
  }

  public String getName() {
    return name;
  }

  public String getHandAsString() {
    return hand.toString();
  }

  public List<Card> getReadOnlyCards() {
    return hand.getReadOnlyCards();
  }

  public abstract boolean shouldDraw();
}
