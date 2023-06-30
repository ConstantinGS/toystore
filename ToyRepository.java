package toystore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ToyRepository {

    private FileManager fileOperation;

    public ToyRepository(FileManager fileOperation) {
        this.fileOperation = fileOperation;
    }

    public String list_Toys() {

        String toys = "";
        PriorityQueue<Toy> toy_queue = fileOperation.readAllLines();

        while (toy_queue.size() > 0) {
            toys += toy_queue.remove() + "\n";
        }

        return toys;
    }

    public void add_Toy(String name, int weight) {

        int newID = 0;
        ArrayList<Integer> listID = new ArrayList<>();
        PriorityQueue<Toy> toy_queue = fileOperation.readAllLines();

        while (!toy_queue.isEmpty()) {
            Toy toy = toy_queue.poll();
            listID.add(toy.getId());
        }

        Collections.sort(listID);

        for (int i = 0; i < listID.size(); i++) {
            if (newID != listID.get(i)) {
                continue;
            }
            newID += 1;
        }

        Toy newToy = new Toy(newID, name, weight);
        toy_queue = fileOperation.readAllLines();
        toy_queue.add(newToy);
        fileOperation.writeToys(toy_queue);

    }

    public String getToy() {

        String gToy;
        PriorityQueue<Toy> toy_queue = fileOperation.readAllLines();

        gToy = toy_queue.remove() + "\n";
        fileOperation.writeToys(toy_queue);

        return gToy;

    }

}
