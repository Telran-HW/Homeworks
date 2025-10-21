package telran.service;

import java.util.List;
import java.util.Map;

public interface Game {
    Long addIdGame();
    Map<String, Integer> makeMove(Long gameId, String userInput);
    List<String> getResults(Long gameId);
}
