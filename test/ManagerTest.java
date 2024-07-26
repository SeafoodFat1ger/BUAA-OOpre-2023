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


        Manager manager2 = new Manager();
        manager2.match("1 712257 tv7Cw");
        manager2.match("1 951293 d!gbC");
        manager2.match("1 274389 2RD!r15L");
        manager2.match("4 274389 66053 9BnZaPY 3 2989001 RegularEquipment");
        manager2.match("4 712257 317886 9BnZaPY 1 2715170 EpicEquipment 0.931");
        manager2.match("2 951293 551355 k?vGm 87 2283453 ReinforcedBottle 0.883");
        manager2.match("4 712257 126907 E$XWhQ8% 4 2147199 RegularEquipment");
        manager2.match("7 951293 942661 *St32mTp 4 2258497");
        manager2.match("12 951293 yny*NCln");
        manager2.match("4 712257 519060 9BnZaPY 3 2331470 CritEquipment 100");
        manager2.match("14 3 8 tv7Cw 2RD!r15L d!gbC");
        manager2.match("2000/01-2RD!r15L@tv7Cw-GK1dTg$SR");
        manager2.match("2000/01-tv7Cw-yny*NCln");
        manager2.match("2000/01-d!gbC-yny*NCln");
        manager2.match("2000/02-2RD!r15L@d!gbC-9BnZaPY");
        manager2.match("2000/02-d!gbC-k?vGm");
        manager2.match("2000/02-d!gbC-k?vGm");
        manager2.match("2000/03-d!gbC-^RYFbGq");
        manager2.match("2000/04-2RD!r15L@#-E$XWhQ8%");
        manager2.match("7 274389 553176 Zor68x 4 2896629");
        manager2.match("22 274389");
        manager2.match("8 951293 942661");
        manager2.match("7 274389 877931 YBkK/zx4 1 2800275");
        manager2.match("4 951293 945396 E$XWhQ8% 2 2872464 CritEquipment 53");
        manager2.match("4 712257 713989 9BnZaPY 3 2453780 CritEquipment 99");
        manager2.match("2 951293 60570 k?vGm 52 2282382 ReinforcedBottle 0.306");
        manager2.match("2 274389 868021 k?vGm 93 2303029 RecoverBottle 0.911");
        manager2.match("6 951293 945396");
        manager2.match("2 712257 269753 k?vGm 95 2324582 ReinforcedBottle 0.220");
        manager2.match("4 274389 476697 9BnZaPY 5 2195457 RegularEquipment");
        manager2.match("11 274389 877931");
        manager2.match("7 274389 234412 Zor68x 1 2987607");
        manager2.match("7 951293 291285 *St32mTp 3 2690887");
        manager2.match("2 274389 760488 yny*NCln 63 2270655 RecoverBottle 0.445");
        manager2.match("13 274389 Zor68x");
        manager2.match("6 274389 66053");
        manager2.match("4 712257 449362 GK1dTg$SR 3 2749263 CritEquipment 59");
        manager2.match("13 951293 YBkK/zx4");
        manager2.match("8 951293 291285");
        manager2.match("2 712257 994726 k?vGm 66 2726674 ReinforcedBottle 0.786");
        manager2.match("2 951293 291297 ^RYFbGq 70 2437824 RegularBottle");
        manager2.match("2 712257 169236 k?vGm 76 2681852 RecoverBottle 0.977");
        manager2.match("2 274389 679298 yny*NCln 41 2495386 RegularBottle");
        manager2.match("7 274389 690967 *St32mTp 4 2486730");
        manager2.match("12 274389 ^RYFbGq");
        manager2.match("4 951293 210438 9BnZaPY 3 2051918 RegularEquipment");
        manager2.match("2 712257 155449 yny*NCln 16 2022089 ReinforcedBottle 0.985");
        manager2.match("4 951293 566499 E$XWhQ8% 1 2359481 RegularEquipment");
        manager2.match("3 951293 60570");
        manager2.match("10 712257 169236");
        manager2.match("9 712257 713989");
        manager2.match("4 712257 123253 E$XWhQ8% 5 2034265 CritEquipment 93");
        manager2.match("22 274389");
        manager2.match("4 712257 524181 E$XWhQ8% 1 2117547 CritEquipment 55");
        manager2.match("2 274389 79686 yny*NCln 70 2515666 RecoverBottle 0.260");
        manager2.match("2 274389 266362 ^RYFbGq 74 2103841 ReinforcedBottle 0.843");
        manager2.match("7 274389 830736 YBkK/zx4 3 2581210");
        manager2.match("7 951293 270873 YBkK/zx4 2 2206731");
        manager2.match("12 712257 k?vGm");
        manager2.match("19 951293");
        manager2.match("7 951293 817059 *St32mTp 4 2428346");
        manager2.match("4 951293 739103 GK1dTg$SR 3 2678121 CritEquipment 74");
        manager2.match("2 951293 713546 yny*NCln 35 2300430 ReinforcedBottle 0.648");
        manager2.match("21 274389 868021");
        manager2.match("2 712257 28492 ^RYFbGq 32 2069815 RecoverBottle 0.220");
        manager2.match("12 951293 ^RYFbGq");
        manager2.match("7 712257 664190 YBkK/zx4 5 2753414");
        manager2.match("4 274389 951086 9BnZaPY 5 2608442 EpicEquipment 0.759");
        manager2.match("18 712257 951293");
        manager2.match("2 712257 752362 ^RYFbGq 54 2765124 ReinforcedBottle 0.427");
        manager2.match("4 951293 377391 GK1dTg$SR 3 2625909 CritEquipment 98");
        manager2.match("2 951293 248569 yny*NCln 86 2795851 RegularBottle");
        manager2.match("4 274389 523454 E$XWhQ8% 3 2869491 RegularEquipment");
        manager2.match("2 951293 556105 yny*NCln 45 2581571 RegularBottle");
        manager2.match("4 274389 332043 9BnZaPY 3 2889216 EpicEquipment 0.125");
        manager2.match("18 274389 712257");
        manager2.match("2 951293 345944 yny*NCln 30 2862252 RecoverBottle 0.178");
        manager2.match("11 951293 817059");
        manager2.match("4 712257 689739 E$XWhQ8% 3 2130839 EpicEquipment 0.339");
        manager2.match("4 951293 431694 E$XWhQ8% 4 2125569 RegularEquipment");
        manager2.match("2 951293 920237 ^RYFbGq 49 2816404 ReinforcedBottle 0.702");
        manager2.match("20 274389");
        manager2.match("6 951293 431694");
        manager2.match("22 712257");
        manager2.match("2 274389 856809 k?vGm 23 2004691 RecoverBottle 0.015");
        manager2.match("4 274389 374503 E$XWhQ8% 1 2030482 RegularEquipment");
        manager2.match("18 274389 951293");
        manager2.match("2 274389 217332 ^RYFbGq 80 2967608 ReinforcedBottle 0.614");
        manager2.match("2 274389 673986 ^RYFbGq 61 2394620 RecoverBottle 0.572");
        manager2.match("7 951293 830153 *St32mTp 3 2628977");
        manager2.match("7 951293 410093 *St32mTp 1 2816764");
        manager2.match("2 712257 380479 k?vGm 28 2350657 ReinforcedBottle 0.287");
        manager2.match("5 274389 332043");
        manager2.match("7 951293 997267 Zor68x 3 2755925");
        manager2.match("2 951293 144024 yny*NCln 33 2034382 RecoverBottle 0.818");
        manager2.match("2 712257 263446 yny*NCln 20 2012227 ReinforcedBottle 0.342");
        manager2.match("12 274389 k?vGm");
        manager2.match("6 951293 945396");
        manager2.match("7 951293 720497 *St32mTp 5 2115227");
        manager2.match("7 951293 401330 YBkK/zx4 3 2089473");
        manager2.match("3 712257 994726");
        manager2.match("4 274389 287778 GK1dTg$SR 5 2475181 RegularEquipment");
        manager2.match("7 712257 360434 Zor68x 4 2348672");
        manager2.match("2 712257 549615 yny*NCln 97 2220164 ReinforcedBottle 0.968");
        manager2.match("7 274389 884183 *St32mTp 2 2037011");
        manager2.match("12 274389 ^RYFbGq");
        manager2.match("5 274389 523454");
        manager2.match("4 274389 978636 E$XWhQ8% 3 2526770 RegularEquipment");
        manager2.match("6 274389 951086");
        manager2.match("7 274389 650498 YBkK/zx4 1 2726080");
        manager2.match("2 712257 680297 yny*NCln 96 2368349 RegularBottle");
        manager2.match("2 274389 30688 k?vGm 98 2164401 RecoverBottle 0.308");
        manager2.match("2 274389 839006 yny*NCln 13 2921753 ReinforcedBottle 0.843");
        manager2.match("4 951293 817281 E$XWhQ8% 3 2625096 CritEquipment 56");
        manager2.match("12 951293 ^RYFbGq");
        manager2.match("4 712257 2087 E$XWhQ8% 3 2861846 CritEquipment 77");
        manager2.match("20 274389");
        manager2.match("2 274389 874459 yny*NCln 22 2932681 RegularBottle");
        manager2.match("14 3 5 tv7Cw d!gbC 2RD!r15L");
        manager2.match("2001/05-d!gbC-yny*NCln");
        manager2.match("2001/05-tv7Cw@2RD!r15L-9BnZaPY");
        manager2.match("2001/05-d!gbC@#-GK1dTg$SR");
        manager2.match("2001/05-tv7Cw-k?vGm");
        manager2.match("2001/05-2RD!r15L@d!gbC-9BnZaPY");
        manager2.match("7 712257 747511 YBkK/zx4 4 2870635");
        manager2.match("4 951293 218686 E$XWhQ8% 3 2212016 RegularEquipment");
        manager2.match("12 951293 k?vGm");
        manager2.match("7 274389 631480 *St32mTp 3 2508694");
        manager2.match("12 712257 k?vGm");
        manager2.match("11 951293 401330");
        manager2.match("7 951293 643254 YBkK/zx4 4 2104909");
        manager2.match("4 274389 402108 9BnZaPY 3 2804288 EpicEquipment 0.301");
        manager2.match("12 274389 yny*NCln");
        manager2.match("12 274389 k?vGm");
        manager2.match("2 274389 936867 k?vGm 56 2408309 ReinforcedBottle 0.757");
        manager2.match("23 951293 248933 ^RYFbGq RecoverBottle 0.375");
        manager2.match("2 274389 824871 ^RYFbGq 39 2032971 RecoverBottle 0.803");
        manager2.match("12 274389 ^RYFbGq");
        manager2.match("4 274389 960916 E$XWhQ8% 2 2837304 RegularEquipment");
        manager2.match("7 274389 797234 *St32mTp 4 2444589");
        manager2.match("2 712257 445659 ^RYFbGq 42 2920816 RecoverBottle 0.185");
        manager2.match("8 274389 234412");
        manager2.match("12 951293 k?vGm");
        manager2.match("20 712257");


        Manager manager3 = new Manager();
        manager3.match("1 123 adv1");
        manager3.match("1 124 adv2");
        manager3.match("1 125 adv3");
/////////////////bot////////////////////
        manager3.match("2 123 11 bot1 1 1 RegularBottle");
        manager3.match("3 123 11");
        manager3.match("2 123 11 bot1 1 1 RegularBottle");

        manager3.match("2 123 12 bot2 1 1 ReinforcedBottle 0.1");
        manager3.match("3 123 12");
        manager3.match("2 123 12 bot2 1 1 ReinforcedBottle 0.1");


        manager3.match("2 123 13 bot3 1 1 RecoverBottle 0.1");
        manager3.match("3 123 13");
        manager3.match("2 123 13 bot3 1 1 RecoverBottle 0.1");
        manager3.match("10 123 11");
        manager3.match("10 123 12");
        manager3.match("10 123 13");
///////////////////equ/////////
        manager3.match("4 123 21 equ1 100 1 RegularEquipment");
        manager3.match("5 123 21");
        manager3.match("4 123 21 equ1 100 1 RegularEquipment");

        manager3.match("4 123 22 equ2 100 1 CritEquipment 1");
        manager3.match("5 123 22");
        manager3.match("4 123 22 equ2 100 1 CritEquipment 1");


        manager3.match("4 123 23 equ3 100 1 EpicEquipment 0.1");
        manager3.match("5 123 23");
        manager3.match("4 123 23 equ3 100 1 EpicEquipment 0.1");
        manager3.match("9 123 21");
        manager3.match("9 123 22");
        manager3.match("9 123 23");
        ///////战前准备//////////
        manager3.match("7 123 99 maif1 1 400000");
        manager3.match("7 124 89 maif2 1 900000");
        manager3.match("7 125 79 maif3 1 3000000");
        manager3.match("8 123 99");
        manager3.match("8 124 89 ");
        manager3.match("8 125 79");
        manager3.match("18 124 125");
        /////////////////log/////////////////////
        manager3.match("14 3 4 adv1 adv2 adv3");
        manager3.match("2004/11-adv1@#-equ1");
        manager3.match("2004/11-adv1@#-equ2");
        manager3.match("2004/12-adv1@adv2-equ1");
        manager3.match("2004/12-adv1@adv2-equ2");
        manager3.match("23 123 44 haha RecoverBottle 1");
    }
}