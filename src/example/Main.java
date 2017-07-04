package example;

import engine.BFS;

public class Main {
    public static void main(String[] args) {
        Corridor corridor = new Corridor();
        BFS search = new BFS(corridor);
        search.setResultsListener((solution, nodes, time) -> {
            System.out.println("===SOLUTION FOUND===");
            System.out.println("Reconstructing moves");
            solution.forEach(state -> {
                Corridor node = (Corridor) state;
                System.out.println("Robot is at "+node.robot);
            });
            System.out.println("Time taken : "+time+"ms");
            System.out.println("Opened nodes : "+nodes);
        });
        try {
            System.out.println("....SOLVING....");
            search.solve();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
