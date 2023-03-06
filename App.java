import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class App {
    public void start(ArrayList<Toys> list_t, ArrayDeque<Toys> list_prize, Draw_Toys d) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1: Разыграть игрушку\n2: Получить приз\n3: Посмотреть какие есть призы\n4: Добавить новую игрушку для розыгрыша\n5: Изменить параметры выпадения игрушки\n0: Выход");
            String key = in.next();
            switch (key) {
                case "0":
                    return;
                case "1":
                    d.Get_Prize(list_t, list_prize);
                    break;
                case "2":
                    d.Get_toy(list_prize);
                    break;
                case "3":
                    System.out.println(list_t.toString() + "\n");
                    break;
                case "4":
                    System.out.println("Введите id игрушки: ");
                    String i = in.next();
                    System.out.println("Введите имя игрушки: ");
                    String n = in.next();
                    System.out.println("Введите колличество: ");
                    String c = in.next();
                    System.out.println("Введите шанс выпадения: ");
                    String p = in.next();
                    Toys toy = new Toys(Integer.parseInt(i), n, Integer.parseInt(c), Integer.parseInt(p));
                    toy.Toy_add(list_t, toy);
                    break;
                case "5":
                    if (list_t.isEmpty()) {
                        System.out.println("Вданный момент игрушек нет");
                        break;
                    }
                    System.out.println("Выберите номер игрушки для изменения шансавыпадения\n");
                    for (int j = 0; j < list_t.size(); j++) {
                        System.out.print("'" + (j + 1) + "'" + " :" + list_t.toArray()[j] + "  ");
                    }
                    System.out.println("\n");
                    String t = in.next();
                    System.out.println();
                    System.out.println(list_t.toArray()[Integer.parseInt(t) - 1]);
                    System.out.println("Задайте новую величину выпадения: ");
                    String v = in.next();
                    Toys temp = new Toys(list_t.get(Integer.parseInt(t) - 1).getId(),
                            list_t.get(Integer.parseInt(t) - 1).getToy_name(),
                            list_t.get(Integer.parseInt(t) - 1).getCount(), Integer.parseInt(v));
                    list_t.remove(Integer.parseInt(t) - 1);
                    list_t.add(temp);
                    break;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }
}