package engine;

import heuristics.Heuristics;
import search.Search;
import search.State;

/**
 * A* Search algorithm using heuristics
 */

public class Astar extends Search {

    private Heuristics heuristics;

    public Astar(State initial, Heuristics heuristics){
        super(initial);
        this.heuristics = heuristics;
    }

    @Override
    public int evaluationFunction(State state) {
        return state.getCost() + heuristics.h(state);
    }
}
