import java.util.*;

public interface Garage {

    Collection<Owner> allCarsUniqueOwners();

    /**\2
     * Complexity should be less than O(n)
     TreeSet всех машин по скорости
     */
    Collection<Car> topThreeCarsByMaxVelocity();

    /**3
     * Complexity should be O(1)
     HashMap, ключ: Brand, value: ArrList машин
     */
    Collection<Car> allCarsOfBrand(String brand);

    /**4
     * Complexity should be less than O(n)
     * TreeMap
     */
    Collection<Car> carsWithPowerMoreThan(int power);

    /**5
     * Complexity should be O(1)
     * HashMap, ключ: Owner, value: ArrList машин
     */
    Collection<Car> allCarsOfOwner(Owner owner);

    /**6
     * @return mean value of owner age that has cars with given brand
     */
    int meanOwnersAgeOfCarBrand(String brand);

    /**7
     * @return mean value of cars for all owners
     */
    int meanCarNumberForEachOwner();

    /**8
     * Complexity should be less than O(n)
     * @return removed car
     HashMap
     */
    Car removeCar(int carId);

    /**9
     * Complexity should be less than O(n)
     * HashMap
     */
    void addNewCar(Car car, Owner owner);
}

class MyGarage implements Garage {
    Map<String, ArrayList<Car>> hm1;
    Map<String, ArrayList<Car>> hm2;

    public Garage () {
        hm1 = new HashMap<String, ArrayList<Car>>();
        hm2 = new HashMap<String, ArrayList<Car>>();
    }

    Collection<Owner> allCarsUniqueOwners() {
        return new HashSet();
    }

    Collection<Car> topThreeCarsByMaxVelocity() {
        return new HashSet();
    }

    Collection<Car> allCarsOfBrand(String brand) {
        return new HashSet();
    }

    Collection<Car> carsWithPowerMoreThan(int power) {
        return new HashSet();
    }

    Collection<Car> allCarsOfOwner(Owner owner) {
        return new HashSet();
    }

    int meanOwnersAgeOfCarBrand(String brand) {
        return 0;
    }

    int meanCarNumberForEachOwner() {
        return 0;
    }

    Car removeCar(int carId) {
        return new Car(1234, "Lada", "VAZ2101", 80, 100, 12);
    }

    void addNewCar(Car car, Owner owner) {

    }
}