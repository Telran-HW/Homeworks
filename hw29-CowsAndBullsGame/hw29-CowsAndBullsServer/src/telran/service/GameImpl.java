package telran.service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("serial")
public class GameImpl implements Game, Serializable {
	
    private final Map<Long, List<String>> results;
    private long idCounter;
    
    public GameImpl() {
		super();
		this.results = new HashMap<>();
		this.idCounter = 1;
	}

	@Override
    public Long addIdGame() {
        long id = idCounter++;
        results.put(id, new ArrayList<>());
        //System.out.println(results);
        return id;
    }

    @Override
    public Map<String, Integer> makeMove(Long gameId, String userInput) {
    	
        Move move = new Move();
        Map<String, Integer> score = move.getScore(userInput);
        
        results.get(gameId).add("Move: " + userInput + " " + score);
        //System.out.println(results);
        return score;
    }

    @Override
    public List<String> getResults(Long gameId) {
    	//System.out.println(results);
        return results.getOrDefault(gameId, List.of("No game found"));
    }
}



