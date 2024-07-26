import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class LogBaseTest {

    String[] advNames = {
            "adv1", "adv2", "adv3"
    };
    Adventure adv1 = new Adventure(1, "adv1");
    Adventure adv2 = new Adventure(2, "adv2");
    Adventure adv3 = new Adventure(3, "adv3");
    HashMap<String, Adventure> adv = new HashMap<>();
    ArrayList<String> records = new ArrayList<>();
    String[] strings = {
            "14","3", "200", "adv1", "adv2", "adv3"
    };

    public void addRecord() {
        records.add("2004/10-adv1-bot1");
        records.add("2004/11-adv1-bot1");
        records.add("2004/11-adv1-bot2");
        records.add("2004/11-advAwful-bot1");
        records.add("2004/11-adv1@#-equ1");
        records.add("2004/11-adv1@#-equ2");
        records.add("2004/11-advAwful@#-equ1");
        records.add("2004/12-adv1@adv2-equ1");
        records.add("2004/12-adv1@adv2-equ2");
        records.add("2004/12-advAwful@adv2-equ1");
        records.add("2004/12-adv1@advAwful-equ1");
        records.add("2004/12-advAwful@advAwful-equ1");
    }

    public void creatHashMap() {
        adv.put("adv1",adv1);
        adv.put("adv2",adv2);
        adv.put("adv3",adv3);
    }

    public void carryAdv() {
        adv1.addBottle(adv1.getBottles(), "1", "bot1", "1");
        adv1.carryBot(adv1.getBottles(), adv1.getBagBottles(), "1");
        adv1.addEqu(adv1.getEquipments(), "1", "equ1", "1");
        adv1.carryEqu(adv1.getEquipments(), adv1.getBagEquipments(), "1");
    }


    @Test
    public void dealString() {
        addRecord();
        creatHashMap();
        carryAdv();
        LogBase logBase = new LogBase(records, strings, adv);
        logBase.dealString();
    }

    @Test
    public void inquireDate() {
        addRecord();
        creatHashMap();
        carryAdv();
        LogBase logBase = new LogBase(records, strings, adv);
        logBase.dealString();
        logBase.inquireDate("2004/11");
        logBase.inquireDate("2004/10");
        logBase.inquireDate("2005/10");
        //System.out.println("哥们是date");
    }
}