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

    @Override
    public String toString() {
        return String.format(carId + " " + brand + ", " + modelName + ", v: " + maxVelocity + ", W: " + power + ", oID: " + ownerId);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = brand.hashCode() + modelName.hashCode();
        result = prime * result + carId;
        result = prime * result + maxVelocity;
        result = prime * result + power;
        result = prime * result + ownerId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car car = (Car) obj;
        if (carId != car.carId)
            return false;
        if (!brand.equals(car.brand))
            return false;
        if (!modelName.equals(car.modelName))
            return false;
        if (maxVelocity != car.maxVelocity)
            return false;
        if (power != car.power)
            return false;
        if (ownerId != car.ownerId)
            return false;
        return true;
    }
}