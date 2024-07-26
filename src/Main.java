import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            Adventure a = adventures.get(Integer.parseInt(strings[1]));
            if (strings[0].equals("1")) {
                Adventure adventure = new Adventure(Integer.parseInt(strings[1]), strings[2]);
                adventures.put(Integer.parseInt(strings[1]), adventure);
            } else if (strings[0].equals("2")) {
                a.addBottle(a.getBottles(), strings[2], strings[3], strings[4]);
            } else if (strings[0].equals("3")) {
                a.delBottle(a.getBottles(), strings[2]);
            } else if (strings[0].equals("4")) {
                a.addEqu(a.getEquipments(), strings[2], strings[3], strings[4]);
            } else if (strings[0].equals("5")) {
                a.delEqu(a.getEquipments(), strings[2]);
            } else if (strings[0].equals("6")) {
                a.addStar(a.getEquipments(), strings[2]);
            } else if (strings[0].equals("7")) {
                a.addFood(a.getFoods(), strings[2], strings[3], strings[4]);
            } else if (strings[0].equals("8")) {
                a.delFood(a.getFoods(), strings[2]);
            } else if (strings[0].equals("9")) {
                a.carryEqu(a.getEquipments(), a.getBagEquipments(), strings[2]);
            } else if (strings[0].equals("10")) {
                a.carryBot(a.getBottles(), a.getBagBottles(), strings[2]);
            } else if (strings[0].equals("11")) {
                a.carryFood(a.getFoods(), a.getBagFoods(), strings[2]);
            } else if (strings[0].equals("12")) {
                a.useBot(a.getBottles(), a.getBagBottles(), strings[2]);
            } else if (strings[0].equals("13")) {
                a.useFood(a.getFoods(), a.getBagFoods(), strings[2]);
            }
        }
        scanner.close(); // 关闭scanner
    }

}