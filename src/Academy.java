import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Academy {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AcademyInfo {
        int year();
    }
    @AcademyInfo(year = 2022)
    public static void finishAcademy(){
        System.out.println("I have completed my studies");
    }
    public static void Event(){
        System.out.println("This event takes place every year");
    }

}
