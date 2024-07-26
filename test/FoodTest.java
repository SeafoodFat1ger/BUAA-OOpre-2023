import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTest {
    int s1 = 2147483647;
    String s2 = "sssssssssssssssssssssssssssssssssssssss";

    @Test
    public void getName() {
        Food e1 = new Food(s1, s2, s1);
        assertEquals(s2, e1.getName());
    }

    @Test
    public void getEnergy() {
        Food e1 = new Food(s1, s2, s1);
        assertEquals(e1.getEnergy(), s1);
    }

    @Test
    public void getId() {
        Food e1 = new Food(s1, s2, s1);
        assertEquals(e1.getId(), s1);
    }
}