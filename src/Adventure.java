import java.util.HashMap;
import java.util.HashSet;
//可能会存在ID不同但名字相同的情况

public class Adventure {
    private int id;
    private String name;
    private int hitPoint;

    public int getLevel() {
        return level;
    }

    private int level;

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.hitPoint = 500;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
        this.foods = new HashMap<>();
        this.bagBottles = new HashSet<>();
        this.bagEquipments = new HashSet<>();
        this.bagFoods = new HashSet<>();
    }

    public HashMap<Integer, Bottle> getBottles() {
        return bottles;
    }

    public HashMap<Integer, Equipment> getEquipments() {
        return equipments;
    }

    public HashMap<Integer, Food> getFoods() {
        return foods;
    }

    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;
    private HashMap<Integer, Food> foods;

    public void addBottle(HashMap<Integer, Bottle> bottles, String id,
                          String botName, String cap) {
        //5.保证增加的装备和药水瓶原本不存在
        int botId = Integer.parseInt(id);
        int capacity = Integer.parseInt(cap);
        Bottle bottle1 = new Bottle(botId, botName, capacity);
        bottles.put(botId, bottle1);
    }

    public void delBottle(HashMap<Integer, Bottle> bottles, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int botId = Integer.parseInt(id);
        Bottle bottle = bottles.get(botId);
        bottles.remove(botId);
        int size = bottles.size();
        System.out.println(size + " " + bottle.getName());
        this.getBagBottles().remove(bottle);
    }

    public void addFood(HashMap<Integer, Food> foods, String id,
                        String botName, String s) {
        //5.保证增加的装备和药水瓶原本不存在
        int foodId = Integer.parseInt(id);
        int energy = Integer.parseInt(s);
        Food food = new Food(foodId, botName, energy);
        foods.put(foodId, food);
    }

    public void delFood(HashMap<Integer, Food> foods, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int foodId = Integer.parseInt(id);
        Food food = foods.get(foodId);
        foods.remove(foodId);
        int size = foods.size();
        System.out.println(size + " " + food.getName());
        this.getBagFoods().remove(food);
    }

    public void addEqu(HashMap<Integer, Equipment> equipments, String id, String equName
            , String s) {
        //5.保证增加的装备和药水瓶原本不存在
        int equId = Integer.parseInt(id);
        int star = Integer.parseInt(s);
        Equipment equ1 = new Equipment(equId, equName, star);
        equipments.put(equId, equ1);
    }

    public void delEqu(HashMap<Integer, Equipment> equipments, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int equId = Integer.parseInt(id);
        Equipment equipment = equipments.get(equId);
        equipments.remove(equId);
        int size = equipments.size();
        System.out.println(size + " " + equipment.getName());
        this.getBagEquipments().remove(equipment);
    }

    public void addStar(HashMap<Integer, Equipment> equipments, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int equId = Integer.parseInt(id);
        Equipment equipment = equipments.get(equId);
        int star = equipment.getStar() + 1;
        equipment.setStar(star);
        System.out.println(equipment.getName() + " " + star);
    }

    ////////////////////////////////////////操作9-13/////////////////////////////////////
    public HashSet<Bottle> getBagBottles() {
        return bagBottles;
    }

    public HashSet<Equipment> getBagEquipments() {
        return bagEquipments;
    }

    public HashSet<Food> getBagFoods() {
        return bagFoods;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private HashSet<Bottle> bagBottles;
    private HashSet<Equipment> bagEquipments;
    private HashSet<Food> bagFoods;

    public void carryEqu(HashMap<Integer, Equipment> equipments,
                         HashSet<Equipment> bagEquipments, String id) {
        int equId = Integer.parseInt(id);
        boolean flag = false;
        Equipment equ1 = equipments.get(equId);
        if (!bagEquipments.contains(equ1)) {
            Equipment equ2 = equ1;
            for (Equipment obj : bagEquipments) {
                if (obj.getName().equals(equ1.getName())) {
                    equ2 = obj;
                    flag = true;
                    //break;
                }
            }
            if (flag) {
                bagEquipments.remove(equ2);
            }
            bagEquipments.add(equ1);
        }
    }

    public void carryBot(HashMap<Integer, Bottle> bottles, HashSet<Bottle> bagBottles, String id) {
        int botId = Integer.parseInt(id);
        int max = getLevel() / 5 + 1;
        int num = 0;
        Bottle bot1 = bottles.get(botId);
        if (!bagBottles.contains(bot1)) {
            for (Bottle obj : bagBottles) {
                if (obj.getName().equals(bot1.getName())) {
                    num++;
                }
            }
            if (num < max) {
                bagBottles.add(bot1);
            }
        }
    }

    public void carryFood(HashMap<Integer, Food> foods, HashSet<Food> bagFoods, String id) {
        int foodId = Integer.parseInt(id);
        Food food1 = foods.get(foodId);
        bagFoods.add(food1);
    }

    public void useBot(HashMap<Integer, Bottle> bottles, HashSet<Bottle> bagBottles,
                       String botName) {
        //操作 12-13 不保证提到的物品已经被携带
        boolean flag = false;
        Bottle botMin = new Bottle(2147483647, "", 0);
        for (Bottle obj : bagBottles) {
            if (obj.getName().equals(botName)) {
                flag = true;
                if (obj.getId() <= botMin.getId()) {
                    botMin = obj;
                }
            }
        }
        if (flag) {
            if (botMin.isFilled()) {
                this.setHitPoint(this.getHitPoint() + botMin.getCapacity());
                botMin.setFilled(false);
            } else {
                bagBottles.remove(botMin);
                bottles.remove(botMin.getId());
            }
            System.out.println(botMin.getId() + " " + this.getHitPoint());
        } else {
            System.out.println("fail to use " + botName);
        }
    }

    public void useFood(HashMap<Integer, Food> foods, HashSet<Food> bagFoods, String foodName) {
        //操作 12-13 不保证提到的物品已经被携带
        boolean flag = false;
        Food foodMin = new Food(2147483647, "", 0);
        for (Food obj : bagFoods) {
            if (obj.getName().equals(foodName)) {
                flag = true;
                if (obj.getId() <= foodMin.getId()) {
                    foodMin = obj;
                }
            }
        }
        if (flag) {
            foods.remove(foodMin.getId());
            bagFoods.remove(foodMin);
            this.setLevel(this.getLevel() + foodMin.getEnergy());
            System.out.println(foodMin.getId() + " " + this.getLevel());
        } else {
            System.out.println("fail to eat " + foodName);
        }
    }

}
