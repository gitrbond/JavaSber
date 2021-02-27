import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        System.out.println("I work!");

        /*Set<Owner> set = new HashSet();
        set.add(new Owner("a", "d", 12, 1234));
        set.add(new Owner("a", "d", 12, 3456));
        System.out.println(set.size());
        for (Owner o : set) {
            System.out.println(o);
        }*/

        Set<Car> set = new HashSet();
        set.add(new Car(1234, "Lada", "VAZ2101", 80, 100, 12));
        set.add(new Car(1454, "Lada", "VAZ2106", 90, 120, 24));
        System.out.println(set.size());
        for (Car o : set) {
            System.out.println(o);
        }
    }
}
