public class TaxiImpl implements Taxi {
    public volatile Order order;
    public final Dispatcher dispatcher;

    TaxiImpl(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public synchronized void placeOrder(Order order) {
        this.order = order;
    }

    public synchronized void executeOrder() {
        System.out.println("Taxi " + Thread.currentThread().getName() + " - executing order");
        try {
            Thread.sleep(order.timeNeeded);
        }
        catch (InterruptedException ignored) {
        }
        order = null;
    }

    @Override
    public void run() {
        while (true) {
            if (order == null) {
                synchronized (this) {
                    try {
                        System.out.println("Taxi " + Thread.currentThread().getName() + " - Waiting for orders");
                        this.wait();
                    }
                    catch (InterruptedException ignored) {
                    }
                }
            }
            else {
                executeOrder();
                synchronized (dispatcher) {
                    dispatcher.notifyAvailable(this);
                    dispatcher.notify();
                }
            }
        }
    }
}