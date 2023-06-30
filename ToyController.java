package toystore;

public class ToyController {

    private final ToyRepository repository;

    public ToyController(ToyRepository repository) {
        this.repository = repository;
    }

    public String getToy() {
        return repository.getToy();
    }

    public String listToys() {
        return repository.list_Toys();
    }

    public void addToy(String name, int weight) {
        repository.add_Toy(name, weight);
    }

}
