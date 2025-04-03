package software.enginer.bluejack;

import java.util.List;

public interface Game {

  void initilizeHands(Deck deck, List<Player> players);

  void playRound(Deck deck, List<Player> players);

  void scoreRound(Deck deck, List<Player> players);
}
