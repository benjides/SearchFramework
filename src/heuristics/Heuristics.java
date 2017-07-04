package heuristics;

import search.State;

/**
 * Interface which contains the Heuristics declaration.
 * Any search must implement this class in order to use Heuristics
 */
public interface Heuristics {
    /**
     * Function which evaluates the Heuristics over a State. (MAY NEED CAST)
     * @param state     Generic State Object (MAY NEED CAST TO YOUR OWN STATE OBJECT)
     * @return int      Heristic value
     */
    int h(State state);
}
