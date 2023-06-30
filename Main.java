package toystore;

import toystore.Toy;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        FileManager filem = new FileManager("toystore/data.csv");
        ToyRepository toyRep = new ToyRepository(filem);
        ToyController toyController = new ToyController(toyRep);
        View toyView = new View(toyController);
        toyView.run();

    }
}
