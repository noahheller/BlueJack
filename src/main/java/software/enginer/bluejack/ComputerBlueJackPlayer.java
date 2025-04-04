package software.enginer.bluejack;

public class ComputerBlueJackPlayer extends Player {

  public ComputerBlueJackPlayer(String name) {
    super(name);
  }

  @Override
  public boolean shouldDraw() {
    int minPoints = BlueJack.getMinPoints(getReadOnlyCards());
    int maxPoints = BlueJack.getMaxPoints(getReadOnlyCards());
    return minPoints <= 16 && maxPoints <= 20;
  }

}
