import org.junit.Test;

import static org.junit.Assert.*;

public class AdventureTest {
    int advId = 2147483647;
    String s1 = "2147483647";
    String s2 = "sssssssssssssssssssssssssssssssssssssss";
    String s3 = "0";

    @Test
    public void getBottles() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getBottles().size(), 0);
    }

    @Test
    public void getEquipments() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getEquipments().size(), 0);
    }

    @Test
    public void addBottle() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addBottle(a1.getBottles(), s1, s2, s1);
        assertEquals(s2, a1.getBottles().get(advId).getName());
    }

    @Test
    public void addEqu() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addEqu(a1.getEquipments(), s1, s2, s1);
        assertEquals(s2, a1.getEquipments().get(advId).getName());
    }

    @Test
    public void delBottle() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addBottle(a1.getBottles(), "0", "s", "0");
        a1.carryBot(a1.getBottles(), a1.getBagBottles(), "0");
        Bottle b = a1.getBottles().get(0);
        assertTrue(a1.getBagBottles().contains(b));
        a1.delBottle(a1.getBottles(), "0");
        assertFalse(a1.getBagBottles().contains(b));
    }

    @Test
    public void delEqu() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addEqu(a1.getEquipments(), "0", "s", "0");
        a1.carryEqu(a1.getEquipments(), a1.getBagEquipments(), "0");
        Equipment b = a1.getEquipments().get(0);
        assertTrue(a1.getBagEquipments().contains(b));
        a1.delEqu(a1.getEquipments(), "0");
        assertFalse(a1.getBagEquipments().contains(b));
    }

    @Test
    public void addStar() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addEqu(a1.getEquipments(), s1, s2, s3);
        a1.addStar(a1.getEquipments(), s1);
        int oid = Integer.parseInt(s1);
        assertEquals(a1.getEquipments().get(oid).getStar(), 1);
    }

    @Test
    public void getLevel() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getLevel(), 1);
    }

    @Test
    public void getFoods() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getFoods().size(), 0);
    }

    @Test
    public void addFood() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addFood(a1.getFoods(), s1, s2, s1);
        int oid = Integer.parseInt(s1);
        assertEquals(s2, a1.getFoods().get(oid).getName());
    }

    @Test
    public void delFood() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addFood(a1.getFoods(), "0", "s", "0");
        a1.carryFood(a1.getFoods(), a1.getBagFoods(), "0");
        Food b = a1.getFoods().get(0);
        assertTrue(a1.getBagFoods().contains(b));
        a1.delFood(a1.getFoods(), "0");
        assertFalse(a1.getBagFoods().contains(b));
    }

    @Test
    public void getBagBottles() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getBagBottles().size(), 0);
    }

    @Test
    public void getBagEquipments() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getBagEquipments().size(), 0);
    }

    @Test
    public void getBagFoods() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getBagFoods().size(), 0);
    }

    @Test
    public void getHitPoint() {
        Adventure a1 = new Adventure(advId, s2);
        assertEquals(a1.getHitPoint(), 500);
    }

    @Test
    public void setHitPoint() {
        Adventure a1 = new Adventure(advId, s2);
        a1.setHitPoint(a1.getHitPoint() + 1);
        assertEquals(a1.getHitPoint(), 501);
    }

    @Test
    public void setLevel() {
        Adventure a1 = new Adventure(advId, s2);
        a1.setLevel(a1.getLevel() + 1);
        assertEquals(a1.getLevel(), 2);
    }

    @Test
    public void carryEqu() {
        Adventure a1 = new Adventure(advId, s2);
        a1.addEqu(a1.getEquipments(), "12", "12", s3);
        a1.carryEqu(a1.getEquipments(), a1.getBagEquipments(), "12");
        int i1 = Integer.parseInt(s1);
        a1.addEqu(a1.getEquipments(), s1, s2, s3);
        a1.carryEqu(a1.getEquipments(), a1.getBagEquipments(), s1);
        assertTrue(a1.getBagEquipments().contains(a1.getEquipments().get(i1)));
        a1.addEqu(a1.getEquipments(), "11", s2, s3);
        a1.carryEqu(a1.getEquipments(), a1.getBagEquipments(), "11");
        assertTrue(a1.getBagEquipments().contains(a1.getEquipments().get(11)));
        assertFalse(a1.getBagEquipments().contains(a1.getEquipments().get(i1)));
    }

    @Test
    public void carryBot() {
        Adventure a1 = new Adventure(advId, s2);
        a1.setLevel(6);
        int i1 = Integer.parseInt(s1);
        a1.addBottle(a1.getBottles(), s1, s2, s3);
        a1.carryBot(a1.getBottles(), a1.getBagBottles(), s1);
        assertTrue(a1.getBagBottles().contains(a1.getBottles().get(i1)));
        a1.addBottle(a1.getBottles(), "11", s2, s3);
        a1.carryBot(a1.getBottles(), a1.getBagBottles(), "11");
        assertTrue(a1.getBagBottles().contains(a1.getBottles().get(11)));
        a1.addBottle(a1.getBottles(), "22", s2, s3);
        a1.carryBot(a1.getBottles(), a1.getBagBottles(), "22");
        assertFalse(a1.getBagBottles().contains(a1.getBottles().get(22)));
    }

    @Test
    public void carryFood() {
        Adventure a1 = new Adventure(advId, s2);
        a1.setLevel(6);
        int i1 = Integer.parseInt(s1);
        a1.addFood(a1.getFoods(), s1, s2, s3);
        a1.carryFood(a1.getFoods(), a1.getBagFoods(), s1);
        assertTrue(a1.getBagFoods().contains(a1.getFoods().get(i1)));
    }

    @Test
    public void useBot() {
        Adventure a1 = new Adventure(advId, s2);
        a1.setLevel(6);
        int i1 = Integer.parseInt(s1);
        a1.addBottle(a1.getBottles(), s1, s2, "2");
        a1.carryBot(a1.getBottles(), a1.getBagBottles(), s1);
        a1.addBottle(a1.getBottles(), "0", s2, "1");
        a1.carryBot(a1.getBottles(), a1.getBagBottles(), "0");
        a1.useBot(a1.getBottles(), a1.getBagBottles(), s2);
        assertEquals(a1.getHitPoint(), 501);
        a1.useBot(a1.getBottles(), a1.getBagBottles(), s2);
        assertFalse(a1.getBagBottles().contains(a1.getBottles().get(0)));
        assertFalse(a1.getBottles().containsKey(0));
        a1.useBot(a1.getBottles(), a1.getBagBottles(), s2);
        assertEquals(a1.getHitPoint(), 503);
        a1.useBot(a1.getBottles(), a1.getBagBottles(), s2);
        assertFalse(a1.getBagBottles().contains(a1.getBottles().get(i1)));
        assertFalse(a1.getBottles().containsKey(i1));
        a1.useBot(a1.getBottles(), a1.getBagBottles(), s2);
    }

    @Test
    public void useFood() {
        Adventure a1 = new Adventure(advId, s2);
        int i1 = Integer.parseInt(s1);
        a1.addFood(a1.getFoods(), s1, s2, "2");
        a1.carryFood(a1.getFoods(), a1.getBagFoods(), s1);
        a1.addFood(a1.getFoods(), "0", s2, "1");
        a1.carryFood(a1.getFoods(), a1.getBagFoods(), "0");
        a1.useFood(a1.getFoods(), a1.getBagFoods(), s2);
        assert (a1.getLevel() == 2);
        assert (!a1.getBagFoods().contains(a1.getFoods().get(0)));
        assert (!a1.getFoods().containsKey(0));
        a1.useFood(a1.getFoods(), a1.getBagFoods(), s2);
        assert (a1.getLevel() == 4);
        assert (!a1.getBagFoods().contains(a1.getFoods().get(i1)));
        assert (!a1.getFoods().containsKey(i1));
        a1.useFood(a1.getFoods(), a1.getBagFoods(), s2);
    }
}