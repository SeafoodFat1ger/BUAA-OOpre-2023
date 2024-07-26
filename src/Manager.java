import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private HashMap<Integer, Adventure> adventures = new HashMap<>();
    private HashMap<String, Adventure> a2 = new HashMap<>();
    private ArrayList<Log> logs = new ArrayList<>();

    private String str14;

    public Manager() {
    }

    public void addAdv1(String[] strings) {
        Adventure adventure = new Adventure(Integer.parseInt(strings[1]), strings[2]);
        adventures.put(Integer.parseInt(strings[1]), adventure);
        a2.put(strings[2], adventure);
    }

    public void addBottle(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.addBottle(a.getBottles(), strings[2], strings[3], strings[4]);
    }

    public void delBottle(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.delBottle(a.getBottles(), strings[2]);
    }

    public void addEqu(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.addEqu(a.getEquipments(), strings[2], strings[3], strings[4]);
    }

    public void delEqu(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.delEqu(a.getEquipments(), strings[2]);
    }

    public void addStar(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.addStar(a.getEquipments(), strings[2]);
    }

    public void addFood(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.addFood(a.getFoods(), strings[2], strings[3], strings[4]);
    }

    public void delFood(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.delFood(a.getFoods(), strings[2]);
    }

    public void carryEqu(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.carryEqu(a.getEquipments(), a.getBagEquipments(), strings[2]);

    }

    public void carryBot(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.carryBot(a.getBottles(), a.getBagBottles(), strings[2]);

    }

    public void carryFood(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.carryFood(a.getFoods(), a.getBagFoods(), strings[2]);

    }

    public void useBot(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.useBot(a.getBottles(), a.getBagBottles(), strings[2]);

    }

    public void useFood(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        a.useFood(a.getFoods(), a.getBagFoods(), strings[2]);
    }

    public void askDate(String[] strings) {
        boolean flag = false;
        String[] strings1 = strings[1].split("/");
        int numYm = Integer.parseInt(strings1[0] + strings1[1]);
        for (Log obj : logs) {
            if (numYm == obj.getNumYm()) {
                obj.output();
                flag = true;
            } else if (numYm < obj.getNumYm()) {
                break;
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }

    public void askAttack(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        ArrayList<Log> attackLogs = a.getAttack();
        if (attackLogs.isEmpty()) {
            System.out.println("No Matched Log");
        } else {
            for (Log obj : attackLogs) {
                obj.output();
            }
        }
    }

    public void askBeAttacked(String[] strings) {
        Adventure a = adventures.get(Integer.parseInt(strings[1]));
        ArrayList<Log> beAttackLogs = a.getBeAttack();
        if (beAttackLogs.isEmpty()) {
            System.out.println("No Matched Log");
        } else {
            for (Log obj : beAttackLogs) {
                obj.output();
            }
        }
    }

    public void match(String string) {
        String[] strings = string.trim().split(" +");
        if (strings[0].equals("1")) {
            addAdv1(strings);
        } else if (strings[0].equals("2")) {
            addBottle(strings);
        } else if (strings[0].equals("3")) {
            delBottle(strings);
        } else if (strings[0].equals("4")) {
            addEqu(strings);
        } else if (strings[0].equals("5")) {
            delEqu(strings);
        } else if (strings[0].equals("6")) {
            addStar(strings);
        } else if (strings[0].equals("7")) {
            addFood(strings);
        } else if (strings[0].equals("8")) {
            delFood(strings);
        } else if (strings[0].equals("9")) {
            carryEqu(strings);
        } else if (strings[0].equals("10")) {
            carryBot(strings);
        } else if (strings[0].equals("11")) {
            carryFood(strings);
        } else if (strings[0].equals("12")) {
            useBot(strings);
        } else if (strings[0].equals("13")) {
            useFood(strings);
        } else if (strings[0].equals("14")) {
            set14(string);
        } else if (strings[0].equals("15")) {
            askDate(strings);
        } else if (strings[0].equals("16")) {
            askAttack(strings);
        } else if (strings[0].equals("17")) {
            askBeAttacked(strings);
        } else {
            addLog(string);
        }
    }

    public void set14(String string) {
        str14 = string;
        System.out.println("Enter Fight Mode");
    }

    public void addLog(String string) {
        Log log = new Log(string, str14, a2);
        log.dealString();
        if (log.getCorrect()) {
            logs.add(log);
        }
    }

}
