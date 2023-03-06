import java.util.ArrayList;
import java.util.ArrayDeque;

public abstract interface Model {
    ArrayList <Toys> Get_Prize(ArrayList<Toys> list, ArrayDeque<Toys> List_prize);
    ArrayDeque<Toys> Get_toy(ArrayDeque<Toys> toy_list);
}
