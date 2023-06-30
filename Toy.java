package toystore;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }

    public Toy(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int compareTo(Toy o) {
        return o.getWeight() - this.getWeight();
    }

}