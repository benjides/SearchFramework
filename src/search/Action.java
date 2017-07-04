package search;

/**
 * Interface to hold the actions an State can take
 */
public interface Action {
    /**
     * Takes an action based on the provided state
     * If the action for the state is forbidden it must return NULL
     * @param state     Generic State Object (MAY NEED CAST TO YOUR OWN STATE OBJECT)
     * @return State    This method must return your new State declaration created after taking the action using the second constructor.
     */
    State takeAction(State state);
}

