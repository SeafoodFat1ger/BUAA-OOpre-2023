import org.junit.Test;
import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void match() {
        Manager manager = new Manager();
        manager.match("1 123 advName1");
        manager.match("1 124 advName2");
        manager.match("1 125 advName3");
        manager.match("18 123 124");
        manager.match("18 123 125");
        manager.match("2 124 1 botName 20 10 RegularBottle");
        manager.match("4 125 2 equName 12 35 CritEquipment 123");
        manager.match("20 123");
        manager.match("1 126 advName4");
        manager.match("18 124 126");
        manager.match("21 124 126");
        manager.match("21 125 2");
        manager.match("19 123");

        Manager manager1 = new Manager();
        manager1.match("1 123 adv1");
        manager1.match("1 124 adv2");
        manager1.match("1 125 adv3");
/////////////////bot////////////////////
        manager1.match("2 123 11 bot1 1 1 RegularBottle");
        manager1.match("3 123 11");
        manager1.match("2 123 11 bot1 1 1 RegularBottle");

        manager1.match("2 123 12 bot2 1 1 ReinforcedBottle 0.1");
        manager1.match("3 123 12");
        manager1.match("2 123 12 bot2 1 1 ReinforcedBottle 0.1");


        manager1.match("2 123 13 bot3 1 1 RecoverBottle 0.1");
        manager1.match("3 123 13");
        manager1.match("2 123 13 bot3 1 1 RecoverBottle 0.1");
        manager1.match("10 123 11");
        manager1.match("10 123 12");
        manager1.match("10 123 13");
///////////////////equ/////////
        manager1.match("4 123 21 equ1 1 1 RegularEquipment");
        manager1.match("5 123 21");
        manager1.match("4 123 21 equ1 1 1 RegularEquipment");

        manager1.match("4 123 22 equ2 1 1 CritEquipment 1");
        manager1.match("5 123 22");
        manager1.match("4 123 22 equ2 1 1 CritEquipment 1");


        manager1.match("4 123 23 equ3 1 1 EpicEquipment 0.1");
        manager1.match("5 123 23");
        manager1.match("4 123 23 equ3 1 1 EpicEquipment 0.1");
        manager1.match("9 123 21");
        manager1.match("9 123 22");
        manager1.match("9 123 23");

        ///////////////price///////////
        manager1.match("21 123 11");
        manager1.match("21 123 12");
        manager1.match("21 123 13");
        manager1.match("21 123 21");
        manager1.match("21 123 22");
        manager1.match("21 123 23");
        /////////////////log/////////////////////
        manager1.match("14 3 10 adv1 adv2 adv3");
        manager1.match("2004/10-adv1-bot1");
        manager1.match("2004/11-adv1-bot1");
        manager1.match("2004/11-adv1-bot2");
        manager1.match("2004/11-adv1-bot3");
        manager1.match("2004/11-advAwful-bot1");
        manager1.match("2004/11-adv1@#-equ1");
        manager1.match("2004/11-adv1@#-equ2");
        manager1.match("2004/11-advAwful@#-equ1");
        manager1.match("2004/12-adv1@adv2-equ1");
        manager1.match("2004/12-adv1@adv2-equ2");
        manager1.match("2004/12-adv1@adv2-equ3");
        manager1.match("2004/12-adv1@adv2-equ2");
        manager1.match("2004/12-advAwful@adv2-equ1");
        manager1.match("2004/12-adv1@advAwful-equ1");
        manager1.match("2004/12-advAwful@advAwful-equ1");
        manager1.match("15 2004/09");
        manager1.match("15 2004/10");
        manager1.match("15 2004/11");
        manager1.match("15 2004/12");
        manager1.match("16 123");
        manager1.match("16 124");
        manager1.match("17 123");
        manager1.match("17 124");
///////////////////food//////////////////////////
        manager1.match("6 123 21");
        manager1.match("7 123 31 food1 1 1");
        manager1.match("8 123 31");
        manager1.match("7 123 31 food1 1 1");
        manager1.match("11 123 31");
        manager1.match("13 123 food1");

        manager1.match("12 123 12");


    }
}