package software.enginer.bluejack;

public class HumanPlayer extends Player {

  public HumanPlayer(String name) {
    super(name);
  }

  @Override
  public boolean shouldDraw() {
    String choice = Dealer.scanner.nextLine();
    if (choice.equalsIgnoreCase("hit")) {
      return true;
    }
    return false;
  }

}
