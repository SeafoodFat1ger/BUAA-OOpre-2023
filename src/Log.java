import java.util.ArrayList;
import java.util.HashMap;

public class Log {
    private String ym;
    private int numYm;
    private String name1;
    private String name2;
    private String nameOther;
    private HashMap<String, Adventure> adv;
    private ArrayList<String> advNames;
    private Boolean isCorrect;
    private String string;

    public Log(String string, String str14, HashMap<String, Adventure> a2) {
        String[] strings = string.split("-");
        this.ym = strings[0];
        String[] strings1 = ym.split("/");
        this.numYm = Integer.parseInt(strings1[0] + strings1[1]);
        String[] strings2 = str14.split(" +");
        this.advNames = new ArrayList<>();
        this.adv = new HashMap<>();
        for (int j = 0; j < Integer.parseInt(strings2[1]); ++j) {
            Adventure adventure = a2.get(strings2[3 + j]);
            this.adv.put(strings2[3 + j], adventure);
            this.advNames.add(strings2[3 + j]);
        }
        this.nameOther = strings[2];
        this.isCorrect = false;
        this.string = string;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void dealString() {
        String[] line = string.trim().split("-");
        int indexAt = line[1].indexOf("@");
        if (indexAt == -1) { //用药水
            if (adv.containsKey(line[1])) {
                Adventure a1 = adv.get(line[1]);
                if (a1.useBotMode(a1.getBottles(), a1.getBagBottles(), line[2])) {
                    name1 = line[1];
                    name2 = "@";
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }
            } else {
                isCorrect = false;
                System.out.println("Fight log error");
            }
        } else if (line[1].endsWith("#")) { //AOE
            aoe(line, indexAt);
        } else { //1v1
            solo(line, indexAt);
        }
    }

    public void solo(String[] line, int indexAt) {
        name1 = line[1].substring(0, indexAt);
        name2 = line[1].substring(indexAt + 1);
        if (adv.containsKey(name1) && (adv.containsKey(name2))) {
            Adventure a1 = adv.get(name1);
            Adventure a2 = adv.get(name2);
            //int star = a1.useStar(a1.getEquipments(), a1.getBagEquipments(), line[2]);
            boolean flag = false;
            Equipment equ = new Equipment(1, "1", 1, 1);
            for (Equipment obj : a1.getBagEquipments()) {
                if (obj.getName().equals(line[2])) {
                    flag = true;
                    equ = obj;
                    break;
                }
            }
            if (!flag) {
                isCorrect = false;
                System.out.println("Fight log error");
            } else {
                a1.getAttack().add(this);
                a2.getBeAttack().add(this);
                equ.usedBy(a1, a2);////////////////
                //a2.setHitPoint(a2.getHitPoint() - star * a1.getLevel());
                System.out.println(a2.getId() + " " + a2.getHitPoint());
                isCorrect = true;
            }
        } else {
            isCorrect = false;
            System.out.println("Fight log error");
        }

    }

    public void aoe(String[] line, int indexAt) {
        name1 = line[1].substring(0, indexAt);
        if (adv.containsKey(name1)) {
            Adventure a1 = adv.get(name1);
            //int star = a1.useStar(a1.getEquipments(), a1.getBagEquipments(), line[2]);
            boolean flag = false;
            Equipment equ = new Equipment(1, "1", 1, 1);
            for (Equipment obj : a1.getBagEquipments()) {
                if (obj.getName().equals(line[2])) {
                    flag = true;
                    equ = obj;
                    break;
                }
            }

            if (!flag) {
                System.out.println("Fight log error");
                isCorrect = false;
            } else {
                for (String temp : advNames) {
                    if (!temp.equals(name1)) {
                        Adventure a2 = adv.get(temp);
                        a2.getBeAttack().add(this);
                        equ.usedBy(a1, a2);////////////////
                        //a2.setHitPoint(a2.getHitPoint() - star * a1.getLevel());
                        System.out.print(a2.getHitPoint() + " ");
                    }
                }
                a1.getAttack().add(this);
                System.out.print("\n");
                name2 = "#";
                isCorrect = true;
            }
        } else {
            isCorrect = false;
            System.out.println("Fight log error");
        }
    }

    public int getNumYm() {
        return numYm;
    }

    public void output() {
        if (name2.equals("@")) {
            System.out.println(ym + " " + name1 + " used " + nameOther);
        } else if (name2.equals("#")) {
            System.out.println(ym + " " + name1 + " AOE-attacked with " + nameOther);
        } else {
            System.out.println(ym + " " + name1 + " attacked " + name2 + " with " + nameOther);
        }
    }
}
