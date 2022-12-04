

import java.time.LocalDate;


public class NewDate {
    private static NewDate instance;
    private NewDate(){

    }
    public void currentDate(){
        LocalDate date=LocalDate.now() ;
        System.out.println(date);
    }
    public static NewDate getInstance(){
        if (instance==null){
            instance=new NewDate();
        }
        return instance;
    }
}
