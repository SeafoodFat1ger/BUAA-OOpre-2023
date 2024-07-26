import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class InputTest {

    public ArrayList<String> names = new ArrayList<>();
    public String[] string = {
            "1 1 1",
            "1 2 2",
            "2 1 1 1 1",
            "3 1 1",
            "2 1 1 1 1",
            "4 1 1 1 1",
            "5 1 1",
            "4 1 1 1 1",
            "6 1 1",
            "7 1 1 1 1",
            "8 1 1",
            "7 1 1 1 1",
            "9 1 1",
            "10 1 1",
            "11 1 1",
            "12 1 1",
            "13 1 1",
            "14 1 2 1 2",
            "15 1111/11",
            "16 1",
            "17 2",
            "Awful"
    };

    public String[] string1 = {
            "1 1 adv1",
            "1 2 adv2",
            "4 1 3 equ1 1",
            "9 1 3",
    };
    @Test
    public void getBefore14() {
        Input input = new Input();
        String obj = "14 3 2 1 2";
        String[] strings = obj.trim().split(" +");
        input.setBefore14(strings);
        String[] temp = input.getBefore14();
        System.out.println(Arrays.toString(temp));
    }

    @Test
    public void addLog() {
        Input input = new Input();
        String s1 = "2004/11-adv1@adv2-equ1";
        String s2 = "14 2 1 adv1 adv2";
        ArrayList<String> arrayString = new ArrayList<>();
        Adventure a1 = new Adventure(1,"adv1");
        Adventure a2 = new Adventure(2,"adv2");
        input.getAdvName().put("adv1",a1);
        input.getAdvName().put("adv2",a2);
        input.getAdventures().put(1,a1);
        input.getAdventures().put(2,a2);
        a1.addEqu(a1.getEquipments(),"3","equ1","1");
        a1.carryEqu(a1.getEquipments(),a1.getBagEquipments(),"3");
        arrayString.add(s1);
        String[] strings = s2.trim().split(" +");
        input.addLog(arrayString,strings);

    }

    @Test
    public void askDate() {
    }

    @Test
    public void askAttack() {
        Input input = new Input();
        String s1 = "2004/11-adv1@adv2-equ1";
        String s2 = "14 2 1 adv1 adv2";
        ArrayList<String> arrayString = new ArrayList<>();
        Adventure a1 = new Adventure(1,"adv1");
        Adventure a2 = new Adventure(2,"adv2");
        input.getAdvName().put("adv1",a1);
        input.getAdvName().put("adv2",a2);
        input.getAdventures().put(1,a1);
        input.getAdventures().put(2,a2);
        a1.addEqu(a1.getEquipments(),"3","equ1","1");
        a1.carryEqu(a1.getEquipments(),a1.getBagEquipments(),"3");
        arrayString.add(s1);
        String[] strings = s2.trim().split(" +");
        input.addLog(arrayString,strings);
        String s3 = "16  1";
        String[] strings1 = s3.trim().split(" +");
        input.askAttack(strings1);
    }

    @Test
    public void askBeAttacked() {
        Input input = new Input();
        String s1 = "2004/11-adv1@adv2-equ1";
        String s2 = "14 2 1 adv1 adv2";
        ArrayList<String> arrayString = new ArrayList<>();
        Adventure a1 = new Adventure(1,"adv1");
        Adventure a2 = new Adventure(2,"adv2");
        input.getAdvName().put("adv1",a1);
        input.getAdvName().put("adv2",a2);
        input.getAdventures().put(1,a1);
        input.getAdventures().put(2,a2);
        a1.addEqu(a1.getEquipments(),"3","equ1","1");
        a1.carryEqu(a1.getEquipments(),a1.getBagEquipments(),"3");
        arrayString.add(s1);
        String[] strings = s2.trim().split(" +");
        input.addLog(arrayString,strings);
        String s3 = "17  2";
        String[] strings1 = s3.trim().split(" +");
        input.askBeAttacked(strings1);
    }

    @Test
    public void match() {
        Input input = new Input();
        for (String obj : string) {
            String[] strings = obj.trim().split(" +"); // 按空格对行进行分割
            input.match(strings);
        }
    }
}