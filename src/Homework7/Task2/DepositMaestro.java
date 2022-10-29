package Homework7.Task2;

public class DepositMaestro extends Maestro {
    @Override
    public String GetName() {
        return super.GetName() + " Deposit";
    }
}