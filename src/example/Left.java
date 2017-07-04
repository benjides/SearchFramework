package example;

import search.Action;
import search.State;

public class Left implements Action {

    @Override
    public State takeAction(State state) {
        Corridor corridor = (Corridor) state;
        if ((corridor.robot - 1) < 0)
            return null;
        return new Corridor(corridor,corridor.robot--);
    }
}