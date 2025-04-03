package software.enginer.bluejack;

public class ComputerPlayer extends Player {

  public ComputerPlayer(String name) {
    super(name);
  }

  @Override
  public boolean shouldDraw() {
    return getMinPoints() <= 16 && getMaxPoints() <= 20;
  }

}
