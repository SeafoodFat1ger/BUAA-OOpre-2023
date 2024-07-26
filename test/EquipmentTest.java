import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {
    int s1 = 2147483647;
    String s2 = "sssssssssssssssssssssssssssssssssssssss";
    int s3 = 0;

    @Test
    public void getName() {
        Equipment e1 = new Equipment(s1, s2, s1);
        assertEquals(s2,e1.getName());
    }

    @Test
    public void getStar() {
        Equipment e1 = new Equipment(s1, s2, s1);
        assertEquals(e1.getStar(),s1);
    }

    @Test
    public void setStar() {
        Equipment e1 = new Equipment(s1, s2, s3);
        int i;
        for (i = 0; i <= 1998; i++) {
            int j = e1.getStar() + 1;
            e1.setStar(j);
            assertEquals(e1.getStar(),1 + i);
        }
    }
}