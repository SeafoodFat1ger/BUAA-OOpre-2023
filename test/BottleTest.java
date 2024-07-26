import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {
    int s1 = 2147483647;
    String s2 = "sssssssssssssssssssssssssssssssssssssss";

    @Test
    public void getName() {
        Bottle b1 = new Bottle(s1, s2, s1);
        assertEquals(s2, b1.getName());
    }

    @Test
    public void getId() {
        Bottle b1 = new Bottle(s1, s2, s1);
        assertEquals(b1.getId(), s1);
    }

    @Test
    public void getCapacity() {
        Bottle b1 = new Bottle(s1, s2, s1);
        assertEquals(b1.getCapacity(), s1);
    }

    @Test
    public void isFilled() {
        Bottle b1 = new Bottle(s1, s2, s1);
        assertTrue(b1.isFilled());
    }

    @Test
    public void setFilled() {
        Bottle b1 = new Bottle(s1, s2, s1);
        b1.setFilled(false);
        assertFalse(b1.isFilled());
    }
}