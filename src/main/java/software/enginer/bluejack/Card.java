package software.enginer.bluejack;

public class Card {
  private final String suit;
  private final int number;

  public Card(String suit, int number) {
    this.suit = suit;
    this.number = number;
  }

  public String getSuit() {
    return suit;
  }

  public int getNumber() {
    return number;
  }

}
