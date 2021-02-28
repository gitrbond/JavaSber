import java.util.Objects;

public class Car {
    private final int carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;

    public Car(int carId, String brand, String modelName, int maxVelocity, int power, int ownerId) {
        this.carId = carId;
        this.brand = brand;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }

    public Car(int carId) {
        this.carId = carId;
        this.brand = "";
        this.modelName = "";
        this.maxVelocity = 0;
        this.power = 0;
        this.ownerId = 0;
    }

    public int getCarId() {
        return carId;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }

    public int getPower() {
        return power;
    }

    public String getBrand() {
        return brand;
    }

    public int getOwnerId() {
        return ownerId;
    }

    /*@Override
    public int compareTo(Car c) {
        if (c.maxVelocity > param) {
            return 1;
        } else if (o.param < param) {
            return -1;
        } else return Integer.compare(o.id, id);
    }*/

    @Override
    public String toString() {
        return String.format("cId:" + carId + " " + brand + " " + modelName + " v:" + maxVelocity + " p:" + power + " oID:" + ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId;
    }
}