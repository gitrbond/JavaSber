import java.util.HashMap;
import java.util.HashSet;

public class DispatcherImpl implements Dispatcher {
    //private final HashMap<Taxi, Boolean> isTaxiBusy;
    private final HashSet<Taxi> taxisNotBusy;

    public DispatcherImpl() {
        this.taxisNotBusy = new HashSet<>();
        //System.out.println("Диспетчер создан. Мой поток: " + Thread.currentThread().toString());
    }

    public synchronized void addTaxi(Taxi taxi) {
        taxisNotBusy.add(taxi);
    }

    @Override
    public synchronized void notifyAvailable(Taxi taxi) {
        taxisNotBusy.add(taxi);
    }

    @Override
    public void run() {
        while (true) {
            if (!taxisNotBusy.isEmpty()) {
                Taxi taxi = (Taxi)taxisNotBusy.toArray()[0];
                synchronized (taxi) {
                    taxi.placeOrder(new Order());
                    taxisNotBusy.remove(taxi);
                    taxi.notify();
                }
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException ignored) {
                }
            }
            else {
                try {
                    synchronized (this) {
                        System.out.println("Disp " + Thread.currentThread().getName() + " - Waiting for taxis");
                        this.wait();
                    }
                }
                catch (InterruptedException ignored) {
                }
            }
        }
    }
}
