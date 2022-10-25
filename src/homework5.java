import HomeWork5.Time;
import HomeWork5.ATM;

public class homework5 {
    public static void main(String[] args) {
        tsk1();
        tsk2();

    }

    public static void tsk1() {
        Time t1 = new Time(236262632);
        Time t2 = new Time(43656, 43, 11);
        Time t3 = new Time(854350533);
        Time t4 = new Time(5, 6, 5);
        System.out.println(t1.compereTo(t2));
        System.out.println(t1.compereTo(t3));
        System.out.println(t1.compereTo(t4));
        System.out.println(t2.fullSec());
        System.out.println(t4.fullSec());
    }

    public static void tsk2() {
        ATM atm = new ATM(5, 5, 5);
        System.out.println(atm.gettingMoney());
        atm.addMoney(3, 3, 3);
        System.out.println(atm.gettingMoney());
    }
}
