public class Order {
    public final int timeNeeded;

    public Order(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public Order() {
        this.timeNeeded = (int)(Math.random() * 3000);
    }
}