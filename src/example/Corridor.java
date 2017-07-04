package example;

import search.State;


public class Corridor extends State {

    int size;
    int robot;

    Corridor(){
        this.size = (int) (Math.random() * 10) + 15;
        this.robot = (int) (Math.random() * this.size);
        registerAction(new Left());
        registerAction(new Right());
    }

    Corridor(Corridor state, int robot){
        super(state,1);
        this.robot = robot;
        if (this.size == robot)
            setFinalState();
    }

    @Override
    public boolean equals(Object obj) {
        Corridor state = (Corridor) obj;
        return this.robot == state.robot;
    }

    @Override
    public int hashCode() {
        return this.robot;
    }
}
