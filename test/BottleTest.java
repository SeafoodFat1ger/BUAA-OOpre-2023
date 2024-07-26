import org.junit.Test;

public class BottleTest {
    int s1 = 2147483647;
    String s2 = "sssssssssssssssssssssssssssssssssssssss";

    @Test
    public void getName() {
        Bottle b1 = new Bottle(s1, s2, s1);
        assert (s2.equals(b1.getName()));
    }
}