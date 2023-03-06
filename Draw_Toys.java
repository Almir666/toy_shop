import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Draw_Toys implements Model {
    @Override
    public ArrayList<Toys> Get_Prize(ArrayList<Toys> list, ArrayDeque<Toys> list_prize) {
        if (list.isEmpty()) {
            System.out.println("Игрушки закончились, досвидания!");
        } else {
            Random r = new Random();
            Toys draw_list[] = list.toArray(new Toys[list.size()]);
            int sum = 0;
            int count = 0;
            for (int i = 0; i < draw_list.length; i++) {
                sum = sum + draw_list[i].getPeriod();
            }
            int Random_num = r.nextInt(1, sum);

            for (int i = 0; i < draw_list.length; i++) {
                count = count + draw_list[i].getPeriod();
                if (count >= Random_num) {
                    System.out.println("Вы выйграли: " + draw_list[i].getToy_name() + ", поздравляем!" + "\n");
                    list_prize.add(draw_list[i]);
                    Toys temp = new Toys(draw_list[i].getId(), draw_list[i].getToy_name(), draw_list[i].getCount() - 1,
                            draw_list[i].getPeriod());
                    list.remove(i);
                    list.add(temp);
                    if (draw_list[i].getCount() <= 0) {
                        list.remove(i);
                    }
                    if (temp.getCount() <= 0) {
                        list.remove(temp);
                    }
                    break;
                }
            }
        }
        return list;
    }

    @Override
    public ArrayDeque<Toys> Get_toy(ArrayDeque<Toys> toy_list) {
        if (toy_list.isEmpty()) {
            System.out.println("Нет игрушек для выдачи, дождитесь розыгрыша");

        } else {
            System.out.println("Ваш приз: " + toy_list.element().getToy_name() + ", забирайте");
            Date date = new Date();
            File file = new File("/Users/almir/Desktop/Toy_shop/list_toys.txt");
            try (FileWriter fw = new FileWriter(file, true)) {
                try {
                    fw.append("Забрали: " + date + " Игрушка: " + toy_list.poll().getToy_name() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return toy_list;
    }
}
