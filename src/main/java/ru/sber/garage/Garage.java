package ru.sber.garage;

import java.util.*;

public interface Garage {

    Collection<Owner> allCarsUniqueOwners();

    /**\2
     * Complexity should be less than O(n)
     TreeSet всех машин по скорости
     */
    //Collection<Car> topThreeCarsByMaxVelocity();

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
    double meanOwnersAgeOfCarBrand(String brand);

    /**7
     * @return mean value of cars for all owners
     */
    double meanCarNumberForEachOwner();

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