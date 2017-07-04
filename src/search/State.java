package search;

import java.util.ArrayList;

/**
 * Abstract Class with the basic functionality to define a State in the Search Tree
 * Must need to be overridden with your own definition of a State.
 * When overriding it is essentially to define both constructor. The first for the initial State and the second for any created State during runtime
 */
public abstract class State {

    State parent;
    ArrayList<State> children;
    ArrayList<Action> actions;
    int cost;
    boolean isFinal;

    /**
     * Constructor to call to the initial State.
     * When overridden must be called with super();
     */
    public State(){
        this.parent = null;
        this.cost = 0;
        this.children = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.isFinal = false;
    }

    /**
     * Constructor to middle states.
     * During the variable initialization if the state is final the setFinalState() must be called
     * When overridden must be called with super(parent,actionCost);
     * @param parent        Parent state
     * @param actionCost    Cost of the action taken
     */
    public State(State parent,int actionCost){
        this.parent = parent;
        this.cost = parent.cost + actionCost;
        this.children = new ArrayList<>();
        this.actions = parent.actions;
        this.isFinal = false;
    }

    /**
     * Sets the State as a final state.
     * Several final states can be defined. Depending on the search it may stop once 1 is found or wait for the best.
     */
    public void setFinalState(){
        this.isFinal = true;
    }

    /**
     * Generates all the children from this state taking all the possible actions defined
     * @return ArrayList<State>     A List containing all the states generated
     */
    public ArrayList<State> generateChildren(){
        for (Action action : actions){
            State state = action.takeAction(this);
            if (state != null){
                children.add(state);
            }
        }
        return children;
    }

    /**
     * Cumulative cost to reach to this state.
     * @return int      Cost
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * Adds an action to the state.
     * Actions may be added in runtime.
     * @param action        Action using the Action Interface
     */
    public void registerAction(Action action){
        this.actions.add(action);
    }

    /**
     * Method to check if 2 states are essentially the same.
     * For example, in a grid the position 2,5 is the same independently from where has been reached
     * @param obj       State to check with. MAY NEED CASTING TO YOUR OWN STATE DECLARATION
     * @return          Boolean stating if they are the same
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Unique id for each DIFFERENT state
     * Its value doenst really matters while it is DISTINCT for EACH DIFFERENT STATE
     * @return          Unique hash
     */
    @Override
    public abstract int hashCode();

}
