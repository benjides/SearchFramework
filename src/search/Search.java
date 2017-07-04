package search;
import utils.Chronos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Abstract class declaration with the basic functionality of a Search Algorithm
 * May need to be overridden in case of new Search Algorithms added. (SEE engine PACKAGE)
 */
public abstract class Search implements Comparator<State> {

    PriorityQueue<State> open;
    HashSet<State> closed;

    private ResultsListener listener;

    /**
     * Search constructor
     * @param initialState      The initial state of the Search must be provided
     */
    public Search(State initialState){
        this.open = new PriorityQueue<>(this);
        this.closed = new HashSet<>();
        this.open.add(initialState);
    }

    /**
     * Solves the search asynchronously. The Listener must be provided to be able to access the results.
     * @throws Exception        Generic Exception to reflect any kind of risen Exception during the process.
     */
    public void solve() throws Exception{
        Chronos.start();
        State state = this.open.poll();
        while (!state.isFinal) {
            this.closed.add(state);
            state.generateChildren().forEach(child -> {
                if (!this.closed.contains(child))
                    this.open.add(child);
            });
            state = this.open.poll();
        }
        //Solution found
        //Rebuild the tree from bottom to up
        long time = Chronos.stop();
        ArrayList<State> solution = new ArrayList<>();
        while (state.parent != null){
            solution.add(0,state);
            state = state.parent;
        }
        listener.onResults(solution,this.closed.size(),time);
    }

    /**
     * Set the Listener to wait for results of the search
     * @param listener
     */
    public void setResultsListener(ResultsListener listener){
        this.listener = listener;
    }

    /**
     * Evaluation function to evaluate how to place the State inside the list
     * Must be implemented in any Search Algorithm declaration
     * @param state             State to evaluate
     * @return int              Result of the evaluation
     */
    public abstract int evaluationFunction(State state);

    /**
     * Method to compare 2 states to decide where to place inside the list.
     * @param state1            State 1.
     * @param state2            State 2.
     * @return int              Relative order of both states.
     */
    @Override
    public int compare(State state1, State state2) {
        return evaluationFunction(state1) - evaluationFunction(state2);
    }


    /**
     * Result Listener Interface to be able to get results
     */
    public interface ResultsListener {
        /**
         * Method to get results.
         * @param solution      ArrayList containing the tree to get to the final State from the initial State.
         * @param nodes         Number of opened nodes.
         * @param time          Time taken to get to the solution.
         */
        void onResults(ArrayList<State> solution,int nodes,long time);
    }
}
