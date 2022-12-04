import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class HomeWork16 {

    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }

    /*Создать класс Man c произвольным набором полей и методов (не менее 3 полей не менее 3 методов).
     Создать метод, который распечатает информацию о классе (список методов и полей с их типами и доступностью)
      с помощью рефлексии. Вызвать метод с помощью рефлексии из основной программы.*/
    public static void task1() {
        Class<Man> myClass = Man.class;
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            int modField = field.getModifiers();
            System.out.println("field :"
                    + field.getName() + "Type of :"
                    + type.getName() + "Availability :"
                    + Modifier.toString(modField));
            Method[] methods = myClass.getDeclaredMethods();
            for (Method method : methods) {
                Class<?> returnType = method.getReturnType();
                int modifierMethod = method.getModifiers();
                System.out.println("Method :" + method.getName() + "Return type :" + returnType.getName() + "Availability " + Modifier.toString(modifierMethod));
            }
        }
    }

    /*Создайте класс с методом printHelloWorld(). Вызвать метод с помощью рефлексии из основной программы.*/
    public static void task2() {
        Class<HelloWorld> hello = HelloWorld.class;
        Method print = null;
        try {
            print = hello.getDeclaredMethod("printHello");
            print.invoke(hello);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

    /*Создать собственную аннотацию @AcademyInfo c полем year.
     Создать метод, помеченный этой аннотацией с заданным year, и метод без нее.
      С помощью рефлексии проверить наличие данной аннотации у этих методов из основной программы.*/
    public static void task3() {
        Class<Academy> academyClass = Academy.class;
        Method[] methods = academyClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Academy.AcademyInfo academyInfo = methods[i].getAnnotation(Academy.AcademyInfo.class);
            if (academyInfo == null) {
                System.out.println("At the method" + methods[i].getName() + "no annotations");
            } else {
                System.out.println("At the method" + methods[i].getName() + "there is an annotation with year parameter" + academyInfo.year());
            }
        }
    }
}
