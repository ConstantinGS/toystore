package toystore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import toystore.Toy;
import java.util.PriorityQueue;

public class FileManager {

    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    // Читает файл и возвращает приоритетную очередь.
    public PriorityQueue<Toy> readAllLines() {

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            PriorityQueue<Toy> toy_queue = new PriorityQueue<>();
            String lines_string;
            String[] data;

            while ((lines_string = csvReader.readLine()) != null) {

                data = lines_string.split(";");

                Integer id_toy = Integer.parseInt(data[0]);
                String name = data[1];
                Integer w_toy = Integer.parseInt(data[2]);

                Toy new_toy = new Toy(id_toy, name, w_toy);

                toy_queue.add(new_toy);

            }

            csvReader.close();
            return toy_queue;

        } catch (Exception e) {
            System.out.println("error");

        }
        return null;

    }

    public void writeToy(Toy newToy) {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(newToy.getId()));
            sb.append(";");
            sb.append(newToy.getName());
            sb.append(";");
            sb.append(Integer.toString(newToy.getWeight()));
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public void writeToys(PriorityQueue<Toy> queue_newToy) {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            StringBuilder sb = new StringBuilder();

            while (queue_newToy.isEmpty() == false) {

                sb.append(Integer.toString(queue_newToy.element().getId()));
                sb.append(";");
                sb.append(queue_newToy.element().getName());
                sb.append(";");
                sb.append(Integer.toString(queue_newToy.element().getWeight()));
                sb.append("\n");
                queue_newToy.remove(queue_newToy.element());

            }

            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("error");
        }

    }

}