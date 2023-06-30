package toystore;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import toystore.ToyRepository;
import toystore.ToyController;

public class View {

    private ToyController toyController;

    public View(ToyController toyController) {
        this.toyController = toyController;
    }

    public void run() {

        System.out.println("NONE\n GET\n PUT\n LIST\n EXIT\n");
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt(" \n Введите команду: \n");

            try {
                com = Commands.valueOf(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Неопознанная команда");
            }

            if (com == Commands.EXIT)
                return;

            try {
                switch (com) {

                    case PUT:

                        try {
                            String name = "";
                            while (name.equals("")) {
                                name = prompt("Введите название игрушки: ");
                            }
                            Integer weight = Integer.valueOf(prompt("Введите вес: "));
                            toyController.addToy(name, weight);

                        } catch (NumberFormatException e) {
                            System.err.println("Неправильный ввод числа!");
                        }

                        break;

                    case LIST:

                        if (!toyController.listToys().isEmpty()) {
                            System.out.println("Полный список игрушек:");
                            System.out.println(toyController.listToys());
                        } else {
                            System.out.println("Автомат пуст!");
                        }
                        break;

                    case GET:

                        if (!toyController.listToys().isEmpty()) {
                            System.out.println("Выпала игрушка:");
                            System.out.println(toyController.getToy());
                        } else {
                            System.out.println("Автомат пуст!");
                        }
                        break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
