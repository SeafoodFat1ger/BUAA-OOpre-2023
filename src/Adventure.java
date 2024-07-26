import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//可能会存在ID不同但名字相同的情况

public class Adventure implements Commodity, User, Uploader {
    private ArrayList<User> followers = new ArrayList<>();
    // 更新状态 TRUE - 更新了 :) FALSE - 没更新 :(
    //private boolean updatingStatus;

    private int oldHitPoint;

    public int getOldHitPoint() {
        return oldHitPoint;
    }

    public void setOldHitPoint(int oldHitPoint) {
        this.oldHitPoint = oldHitPoint;
    }

    @Override
    public void addFollower(User follower) {
        followers.add(follower);
    }

    @Override
    public void notifyFollowers(int hit) {
        followers.forEach(follower -> follower.watch(this, hit));
    }

    @Override
    public void watch(Uploader up, int hit) {
        Long money = (getMoney() >= hit * 10000L) ? hit * 10000L : getMoney();
        setMoney(getMoney() - money);
        up.addMoney(money);
    }

    @Override
    public void addMoney(Long money) {
        setMoney(getMoney() + money);
    }

    private int id;
    private String name;
    private int hitPoint;
    private Long money;
    private HashMap<Integer, Commodity> commodities;

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Map<Integer, Commodity> getCommodities() {
        return commodities;
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + id + " belongs to Adventurer"
        );
    }

    @Override
    public int getId() {
        return id;
    }

    public long getMaxPrice() {
        long max = 0L;
        long t;
        for (Integer i : commodities.keySet()) {
            t = commodities.get(i).getPrice();
            //if (id == 268338) System.out.println("*******" + i + " " + t);
            max = Math.max(max, t);
        }
        return max;
    }

    public int getComNum() {
        return commodities.size();
    }

    @Override
    public long getPrice() {
        long sum = 0L;
        long t;
        for (Integer i : commodities.keySet()) {
            t = commodities.get(i).getPrice();
            sum = sum + t;
        }
        sum += money;
        return sum;
    }

    public void addCommodity(Commodity commodity) {
        //System.out.println(commodity.getId());
        commodities.put(commodity.getId(), commodity);
    }

    public void delCommodity(int commodityId) {
        commodities.remove(commodityId);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    private int level;

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.hitPoint = 500;
        this.oldHitPoint = 500;
        this.money = 0L;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
        this.foods = new HashMap<>();
        this.bagBottles = new HashSet<>();
        this.bagEquipments = new HashSet<>();
        this.bagFoods = new HashSet<>();
        this.beAttack = new ArrayList<>();
        this.attack = new ArrayList<>();
        this.commodities = new HashMap<>();
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

    public void addBottle(HashMap<Integer, Bottle> bottles, String[] strings) {
        //5.保证增加的装备和药水瓶原本不存在
        Bottle bottle1 = null;
        int botId = Integer.parseInt(strings[2]);
        int capacity = Integer.parseInt(strings[4]);
        Long price = Long.parseLong(strings[5]);
        switch (strings[6]) {
            case "RegularBottle":
                bottle1 = new RegularBottle(
                        botId, strings[3], capacity, price);
                break;
            case "RecoverBottle":
                bottle1 = new RecoverBottle(
                        botId, strings[3], capacity, price, Double.parseDouble(strings[7]));
                break;
            case "ReinforcedBottle":
                bottle1 = new ReinforcedBottle(
                        botId, strings[3], capacity, price, Double.parseDouble(strings[7]));
                break;
            default:
                break;
        }
        bottles.put(botId, bottle1);
        addCommodity(bottle1);////////////
    }

    public void delBottle(HashMap<Integer, Bottle> bottles, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int botId = Integer.parseInt(id);
        Bottle bottle = bottles.get(botId);
        bottles.remove(botId);
        int size = bottles.size();
        System.out.println(size + " " + bottle.getName());
        this.getBagBottles().remove(bottle);
        delCommodity(botId);////////////////
        Shop.getInstance().sell(1, bottle.getCapacity(), bottle.getPrice());
        money += bottle.getPrice();
    }

    public void addFood(HashMap<Integer, Food> foods,
                        String id, String botName, String s, String price) {
        //5.保证增加的装备和药水瓶原本不存在
        int foodId = Integer.parseInt(id);
        int energy = Integer.parseInt(s);
        Food food = new Food(foodId, botName, energy, Long.parseLong(price));
        foods.put(foodId, food);
        addCommodity(food);
    }

    public void delFood(HashMap<Integer, Food> foods, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int foodId = Integer.parseInt(id);
        Food food = foods.get(foodId);
        foods.remove(foodId);
        int size = foods.size();
        System.out.println(size + " " + food.getName());
        this.getBagFoods().remove(food);
        delCommodity(foodId);
        Shop.getInstance().sell(3, food.getEnergy(), food.getPrice());
        money += food.getPrice();
    }

    public void addEqu(HashMap<Integer, Equipment> equipments, String[] strings) {
        //5.保证增加的装备和药水瓶原本不存在
        Equipment equ1 = null;
        int equId = Integer.parseInt(strings[2]);
        int star = Integer.parseInt(strings[4]);
        Long price = Long.parseLong(strings[5]);
        switch (strings[6]) {
            case "RegularEquipment":
                equ1 = new RegularEquipment(
                        equId, strings[3], star, price);
                break;
            case "CritEquipment":
                equ1 = new CritEquipment(
                        equId, strings[3], star, price, Integer.parseInt(strings[7]));
                break;
            case "EpicEquipment":
                equ1 = new EpicEquipment(
                        equId, strings[3], star, price, Double.parseDouble(strings[7]));
                break;
            default:
                break;
        }
        equipments.put(equId, equ1);
        addCommodity(equ1);
    }

    public void delEqu(HashMap<Integer, Equipment> equipments, String id) {
        //4.保证该冒险者拥有操作中提到 id 的药水瓶/装备
        int equId = Integer.parseInt(id);
        Equipment equipment = equipments.get(equId);
        equipments.remove(equId);
        int size = equipments.size();
        System.out.println(size + " " + equipment.getName());
        this.getBagEquipments().remove(equipment);
        delCommodity(equId);
        Shop.getInstance().sell(2, equipment.getStar(), equipment.getPrice());
        //System.out.println(money + "***" + equipment.getPrice());
        money += equipment.getPrice();
        //System.out.println(money + "***" + equipment.getPrice());
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

    public void useBot(HashMap<Integer, Bottle> bottles,
                       HashSet<Bottle> bagBottles, String botName) {
        //操作 12-13 不保证提到的物品已经被携带
        boolean flag = false;
        Bottle botMin = new Bottle(2147483647, "", 0, 0L);
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
                botMin.usedBy(this);
                botMin.setFilled(false);
            } else {
                bagBottles.remove(botMin);
                bottles.remove(botMin.getId());
                delCommodity(botMin.getId());
            }
            System.out.println(botMin.getId() + " " + this.getHitPoint());
        } else {
            System.out.println("fail to use " + botName);
        }
    }

    public void useFood(HashMap<Integer, Food> foods, HashSet<Food> bagFoods, String foodName) {
        //操作 12-13 不保证提到的物品已经被携带
        boolean flag = false;
        Food foodMin = new Food(2147483647, "", 0, 0L);
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
            delCommodity(foodMin.getId());
            this.setLevel(this.getLevel() + foodMin.getEnergy());
            System.out.println(foodMin.getId() + " " + this.getLevel());
        } else {
            System.out.println("fail to eat " + foodName);
        }
    }

    public boolean useBotMode(HashMap<Integer, Bottle> bottles,
                              HashSet<Bottle> bagBottles, String botName) {
        //操作 12-13 不保证提到的物品已经被携带
        boolean flag = false;
        Bottle botMin = new Bottle(2147483647, "", 0, 0L);
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
                botMin.usedBy(this);
                botMin.setFilled(false);
            } else {
                bagBottles.remove(botMin);
                bottles.remove(botMin.getId());
                delCommodity(botMin.getId());
            }
            System.out.println(botMin.getId() + " " + this.getHitPoint());
            return true;
        } else {
            System.out.println("Fight log error");
            return false;
        }
    }

    public int useStar(HashMap<Integer, Equipment> equipments,
                       HashSet<Equipment> bagEquipments, String equName) {
        int star = -1;
        for (Equipment obj : bagEquipments) {
            if (obj.getName().equals(equName)) {
                star = obj.getStar();
                break;
            }
        }
        return star;
    }

    private ArrayList<Log> beAttack;
    private ArrayList<Log> attack;

    public ArrayList<Log> getBeAttack() {
        return beAttack;
    }

    public ArrayList<Log> getAttack() {
        return attack;
    }

}
