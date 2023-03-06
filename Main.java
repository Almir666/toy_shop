import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayList<Toys> list = new ArrayList<>();
        ArrayDeque<Toys> list_prize = new ArrayDeque<>();

        Toys Car = new Toys(1, "Jeep", 1, 40);
        Toys Board_game = new Toys(2, "Carcason", 1, 30);
        Toys Transformer = new Toys(3, "Optimus", 1, 10);
        Toys Bear = new Toys(4, "Teddy", 3, 50);
        Draw_Toys take = new Draw_Toys();
        App app = new App();

        list.add(Bear);
        list.add(Car);
        list.add(Transformer);
        list.add(Board_game);
        app.start(list, list_prize, take);
    }
}

