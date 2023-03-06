import java.util.ArrayList;

public class Toys {
    private int id;
    private String toy_name;
    private int count;
    private int period;

    public int getId() {
        return id;
    }
    public String getToy_name() {
        return toy_name;
    }
    public int getCount() {
        return count;
    }
    public int getPeriod() {
        return period;
    }


    public void setCount(int count) {
        this.count = count;
    }
    public void setPeriod(int period) {
        this.period = period;
    }
    public Toys(int i, String n, int c, int p) {
        id = i;
        toy_name = n;
        count = c;
        period = p;
    }
    public ArrayList<Toys> Toy_add(ArrayList<Toys> Toy_list, Toys new_toy) {
        Toy_list.add(new_toy);
        return Toy_list;
    }
    @Override
    public String toString() {
        return getToy_name();
    }
}
