package HomeWork5;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private int banknote100;
    private int banknote50;
    private int banknote20;

    public ATM(int banknote100, int banknote50, int banknote20) {


        this.banknote100 = banknote100;
        this.banknote50 = banknote50;
        this.banknote20 = banknote20;

    }

    public void addMoney(int banknote100, int banknote50, int banknote20) {
        this.banknote100 += banknote100;
        this.banknote50 += banknote50;
        this.banknote20 += banknote20;
    }

    private int wholeMoney() {
        return banknote100 * 100 + banknote50 * 50 + banknote20 * 20;
    }

    public boolean gettingMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of money");
        try {
            int money = sc.nextInt();
            if (money > wholeMoney()) {
                System.out.println("not enough funds in the ATM");
                return false;
            }
            int note100 = money / 100;
            int note50 = money % 100 / 50;
            int note20 = money % 100 / 20;
            int noteother = money % 100 % 50 % 20;
            if (note100 == 0 && note50 == 0 && note20 == 0) {
                System.out.println("The ATM can only dispense denominations of 20, 50 and 100");
                return false;
            }
            while (banknote100 < note100) {
                note100--;
                note50 += 2;
            }
            while (money - note100 * 100 < 20 && money - note100 * 100 < 50) {
                note100--;
                note50++;
            }
            if (note100 * 100 + note50 * 50 == money) {
            } else if (money - (note100 * 100 + note50 * 50 + noteother) < 20) {
                note50--;
            }
            note20 = (money - (note100 * 100 + note50 * 50)) / 20;
            if (note100 * 100 + note50 * 50 + note20 * 20 == money) {
                noteother = 0;
            }
            if (note20 > banknote20 || note50 > banknote50 || note100 > banknote100 && note50 * 2 > banknote100 && note20 * 5 > banknote100) {
                System.out.println("The ATM can only dispense 20, 50 and 100 banknotes.");
                return false;
            } else {
                banknote100 -= note100;
                banknote50 -= note50;
                banknote20 -= note20;
                System.out.println("Number of banknotes denomination 20 -" + note20);
                System.out.println("Number of banknotes denomination 50 -" + note50);
                System.out.println("Number of banknotes denomination 100 -" + note100);
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect amount entered, must be an integer.");
            return false;


        }
    }
}