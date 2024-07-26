import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void addAdv(HashMap<Integer, Adventure> adventures, int advId, String advName) {
        Adventure adventure = new Adventure(advId, advName);
        adventures.put(advId, adventure);
    }

    public static void addAdvBot(HashMap<Integer, Adventure> adventures, int advId,
                                 int botId, String botName, int capacity) {
        Adventure adventure = adventures.get(advId);
        adventure.addBottle(adventure.getBottles(), botId, botName, capacity);
    }

    public static void addAdvEqu(HashMap<Integer, Adventure> adventures, int advId,
                                 int equId, String equName, int star) {
        Adventure adventure = adventures.get(advId);
        adventure.addEqu(adventure.getEquipments(), equId, equName, star);
    }

    public static void delAdvBot(HashMap<Integer, Adventure> adventures, int advId,
                                 int botId) {
        Adventure adventure = adventures.get(advId);
        adventure.delBottle(adventure.getBottles(), botId);
    }

    public static void delAdvEqu(HashMap<Integer, Adventure> adventures, int advId,
                                 int equId) {
        Adventure adventure = adventures.get(advId);
        adventure.delEqu(adventure.getEquipments(), equId);
    }

    public static void addAdvStar(HashMap<Integer, Adventure> adventures, int advId,
                                  int equId) {
        Adventure adventure = adventures.get(advId);
        adventure.addStar(adventure.getEquipments(), equId);
    }

    public static void main(String[] args) {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割

            switch (strings[0]) {
                case "1":
                    addAdv(adventures, Integer.parseInt(strings[1]), strings[2]);
                    break;

                case "2":
                    addAdvBot(adventures, Integer.parseInt(strings[1]),
                            Integer.parseInt(strings[2]), strings[3], Integer.parseInt(strings[4]));
                    break;

                case "3":
                    delAdvBot(adventures, Integer.parseInt(strings[1]),
                            Integer.parseInt(strings[2]));
                    break;
                case "4":
                    addAdvEqu(adventures, Integer.parseInt(strings[1]),
                            Integer.parseInt(strings[2]), strings[3], Integer.parseInt(strings[4]));
                    break;
                case "5":
                    delAdvEqu(adventures, Integer.parseInt(strings[1]),
                            Integer.parseInt(strings[2]));
                    break;
                case "6":
                    addAdvStar(adventures, Integer.parseInt(strings[1]),
                            Integer.parseInt(strings[2]));
                    break;
                default:
                    break;
            }
        }
        scanner.close(); // 关闭scanner
    }

}