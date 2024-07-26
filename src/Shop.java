import java.util.Iterator;

public class Shop {
    private static Shop shop = new Shop();
    private int capacity = 0;
    private int bottle = 0;
    private Long bprice = 0L;
    private Long eprice = 0L;
    private Long fprice = 0L;
    private int equip = 0;
    private int food = 0;
    private int star = 0;
    private int energy = 0;

    public static Shop getInstance() {
        return shop;
    }

    public void sell(int type, int num, Long price) {
        if (type == 1) {
            capacity += num;
            bottle++;
            bprice += price;
        } else if (type == 2) {
            star += num;
            equip++;
            eprice += price;
        } else if (type == 3) {
            energy += num;
            food++;
            fprice += price;
        }

    }

    public void sellAll(Adventure a1) {
        //移除价值体、迭代器\卖出所有携带
        // 2. 使用 Iterator 遍历 HashMap KeySet
        Long sum = 0L;
        long t;
        Iterator<Bottle> iterator = a1.getBagBottles().iterator();
        while (iterator.hasNext()) {
            Bottle b1 = iterator.next();
            iterator.remove();
            t = b1.getPrice();
            sum += t;
            shop.sell(1, b1.getCapacity(), b1.getPrice());
            a1.setMoney(a1.getMoney() + b1.getPrice());
            a1.getBottles().remove(b1.getId());
            a1.getCommodities().remove(b1.getId());
        }
        Iterator<Equipment> iterator1 = a1.getBagEquipments().iterator();
        while (iterator1.hasNext()) {
            Equipment e1 = iterator1.next();
            iterator1.remove();
            t = e1.getPrice();
            sum += t;
            shop.sell(2, e1.getStar(), e1.getPrice());
            a1.setMoney(a1.getMoney() + e1.getPrice());
            a1.getEquipments().remove(e1.getId());
            a1.getCommodities().remove(e1.getId());
        }
        Iterator<Food> iterator2 = a1.getBagFoods().iterator();
        while (iterator2.hasNext()) {
            Food f1 = iterator2.next();
            iterator2.remove();
            t = f1.getPrice();
            sum += t;
            shop.sell(3, f1.getEnergy(), f1.getPrice());
            a1.setMoney(a1.getMoney() + f1.getPrice());
            a1.getFoods().remove(f1.getId());
            a1.getCommodities().remove(f1.getId());
        }
        System.out.println(a1.getName() + " emptied the backpack " + sum);
        //a1.setMoney(a1.getMoney() + sum);
    }

    public void buy(Adventure a1, String[] strings) {

        if (strings[4].equals("RegularBottle")
                || strings[4].equals("RecoverBottle") || strings[4].equals("ReinforcedBottle")) {
            buyBottle(a1, strings);
        } else if (strings[4].equals("RegularEquipment")
                || strings[4].equals("CritEquipment") || strings[4].equals("EpicEquipment")) {
            buyEqu(a1, strings);
        } else if (strings[4].equals("Food")) {
            buyFood(a1, strings);
        }
    }

    public void buyBottle(Adventure a1, String[] strings) {
        String[] s1 = new String[8];
        Long price = (bottle == 0) ? 0L : bprice / bottle;
        if (a1.getMoney() >= price) {
            a1.setMoney(a1.getMoney() - price);
            s1[2] = strings[2];
            s1[3] = strings[3];
            int cap = (bottle == 0) ? 0 : capacity / bottle;
            s1[4] = String.valueOf(cap);
            s1[5] = String.valueOf(price);
            s1[6] = strings[4];
            if (!strings[4].equals("RegularBottle")) {
                s1[7] = strings[5];
            }
            System.out.println("successfully buy " + strings[3] + " for " + price);
            a1.addBottle(a1.getBottles(), s1);
        } else {
            //System.out.println(bprice+" "+bottle+" ");
            System.out.println("failed to buy " + strings[3] + " for " + price);
        }

    }

    public void buyFood(Adventure a1, String[] strings) {
        //String[] s1 = new String[8];
        Long price = (food == 0) ? 0L : fprice / food;
        int en = (food == 0) ? 0 : energy / food;
        if (a1.getMoney() >= price) {
            a1.setMoney(a1.getMoney() - price);
            System.out.println("successfully buy " + strings[3] + " for " + price);//////////靠错了啊啊啊啊
            a1.addFood(a1.getFoods(), strings[2], strings[3],
                    String.valueOf(en), String.valueOf(price));
        } else {
            System.out.println("failed to buy " + strings[3] + " for " + price);
        }

    }

    public void buyEqu(Adventure a1, String[] strings) {
        String[] s1 = new String[8];
        Long price = (equip == 0) ? 0L : eprice / equip;
        if (a1.getMoney() >= price) {
            a1.setMoney(a1.getMoney() - price);
            s1[2] = strings[2];
            s1[3] = strings[3];
            int starr = (equip == 0) ? 0 : star / equip;
            s1[4] = String.valueOf(starr);
            s1[5] = String.valueOf(price);
            s1[6] = strings[4];
            if (!strings[4].equals("RegularEquipment")) {
                s1[7] = strings[5];
            }
            System.out.println("successfully buy " + strings[3] + " for " + price);
            a1.addEqu(a1.getEquipments(), s1);
        } else {
            System.out.println("failed to buy " + strings[3] + " for " + price);
        }

    }
}
