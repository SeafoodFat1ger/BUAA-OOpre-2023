import org.junit.Test;

import static org.junit.Assert.*;

public class MyScannerTest {

    @Test
    public void handleInput() {
        MyScanner myScanner = new MyScanner();
        myScanner.handleInput("14 3 2 adv1 adv2 adv3");
        myScanner.handleInput("2004/11-adv@adv2-equ1");
    }
}