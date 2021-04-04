import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        //System.out.println("I work!");
        int N = 3; // number of taxis
        DispatcherImpl dispatcher = new DispatcherImpl();
        for (int i = 0; i < N; i++) {
            Taxi newtaxi = new TaxiImpl(dispatcher);
            Thread taxiThread = new Thread(newtaxi);
            dispatcher.addTaxi(newtaxi);
            taxiThread.start();
        }

        Thread dispactherThread = new Thread(dispatcher);
        dispactherThread.start();
    }
}
