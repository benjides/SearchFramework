package example;

import search.Action;
import search.State;

public class Right implements Action {

    @Override
    public State takeAction(State state) {
        Corridor corridor = (Corridor) state;
        return new Corridor(corridor,corridor.robot++);
    }
}