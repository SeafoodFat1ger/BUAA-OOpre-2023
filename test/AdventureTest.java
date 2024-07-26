import org.junit.Test;

public class AdventureTest {
    int s1 = 2147483647;
    String s2 = "sssssssssssssssssssssssssssssssssssssss";
    int s3 = 0;

    @Test
    public void addBottle() {
        Adventure a1 = new Adventure(s1, s2);
        a1.addBottle(a1.getBottles(),s1, s2, s1);
        assert (s2.equals(a1.getBottles().get(s1).getName()));
    }

    @Test
    public void addEqu() {
        Adventure a1 = new Adventure(s1, s2);
        a1.addEqu(a1.getEquipments(),s1, s2, s1);
        assert (s2.equals(a1.getEquipments().get(s1).getName()));
    }

    @Test
    public void delBottle() {
        Adventure a1 = new Adventure(s1, s2);
        int i;
        for (i = 0; i <= 1998; i++) {
            a1.addBottle(a1.getBottles(),s1 - i, s2, s1);
        }
        for (i = 0; i <= 1998; i++) {
            a1.delBottle(a1.getBottles(),s1 - i);
            assert (a1.getBottles().size() == 1998 - i);
        }
    }

    @Test
    public void delEqu() {
        Adventure a1 = new Adventure(s1, s2);
        int i;
        for (i = 0; i <= 1998; i++) {
            a1.addEqu(a1.getEquipments(),s1 - i, s2, s1);
        }
        for (i = 0; i <= 1998; i++) {
            a1.delEqu(a1.getEquipments(),s1 - i);
            assert (a1.getEquipments().size() == 1998 - i);
        }
    }

    @Test
    public void addStar() {
        Adventure a1 = new Adventure(s1, s2);
        a1.addEqu(a1.getEquipments(),s1, s2, s3);
        int i;
        for (i = 0; i <= 1998; i++) {
            a1.addStar(a1.getEquipments(),s1);
            assert (a1.getEquipments().get(s1).getStar() == 1 + i);
        }
    }
}