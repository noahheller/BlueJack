package software.enginer.bluejack;

public class Main {
  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    System.out.println("How many human players are there");
    int humanCount = Dealer.scanner.nextInt();
    for (int i = 0; i < humanCount; i++) {
      System.out.println("What is Player" + i + " 's name?");
      String name = Dealer.scanner.nextLine();
      dealer.addPlayer(new HumanPlayer(name));
    }

    System.out.println("How many computer players are there");
    int computerCount = Dealer.scanner.nextInt();
    for (int i = 0; i < computerCount; i++) {
      dealer.addPlayer(new ComputerPlayer("Computer" + (i + 1)));
    }
    dealer.play();
  }
}
