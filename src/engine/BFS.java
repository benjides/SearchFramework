package engine;

import search.Search;
import search.State;

/**
 * Best First Search algorithm expanding most promising node
 */

public class BFS extends Search {

    public BFS(State initial){
        super(initial);
    }

    @Override
    public int evaluationFunction(State state) {
        return state.getCost();
    }

}
