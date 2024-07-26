import java.util.HashMap;

//可能会存在ID不同但名字相同的情况

public class Adventure {
    private int id;
    private String name;

    public HashMap<Integer, Bottle> getBottles() {
        return bottles;
    }

    public HashMap<Integer, Equipment> getEquipments() {
        return equipments;
    }

    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;

    public void addBottle(HashMap<Integer, Bottle> bottles, int botId,
                          String botName, int capacity) {
        //5.保证增加的装备和药水瓶原本不存在
        Bottle bottle1 = new Bottle(botId, botName, capacity);
        bottles.put(botId, bottle1);
    }

    public void addEqu(HashMap<Integer, Equipment> equipments, int equId, String equName
            , int star) {
        //5.保证增加的装备和药水瓶原本不存在
        Equipment equ1 = new Equipment(equId, equName, star);
        equipments.put(equId, equ1);
    }

    public void delBottle(HashMap<Integer, Bottle> bottles, int botId) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        if (bottles.containsKey(botId)) {
            Bottle bottle = bottles.get(botId);
            bottles.remove(botId);
            int size = bottles.size();
            System.out.println(size + " " + bottle.getName());
        }
    }

    public void delEqu(HashMap<Integer, Equipment> equipments, int equId) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        if (equipments.containsKey(equId)) {
            Equipment equipment = equipments.get(equId);
            equipments.remove(equId);
            int size = equipments.size();
            System.out.println(size + " " + equipment.getName());
        }
    }

    public void addStar(HashMap<Integer, Equipment> equipments, int equId) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        if (equipments.containsKey(equId)) {
            Equipment equipment = equipments.get(equId);
            int star = equipment.getStar() + 1;
            equipment.setStar(star);
            System.out.println(equipment.getName() + " " + star);
        }
    }

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
    }
}
