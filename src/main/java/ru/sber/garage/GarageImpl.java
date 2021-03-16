package ru.sber.garage;

import java.util.*;

public class GarageImpl implements Garage {
    HashMap<Integer, Owner> owners;         // ownerId - Owner
    HashMap<Integer, Car> cars;             // carId - Car
    HashMap<Owner, HashSet<Car>> ownercars; // key = Owner, value = HashSet of Car's
    HashMap<String, HashSet<Car>> brandcars;// key = Brand, value = HashSet of Car's
    //SortedSet<Car> carpowers;
    TreeMap<CarProperty, Car> carpowers = new TreeMap<>();      // key = {power, carId}
    TreeMap<CarProperty, Car> carvelocities = new TreeMap<>();  // key = {velocity, carId}

    static class CarProperty implements Comparable<CarProperty> {
        int carProperty;
        int carId;

        public CarProperty(int carProperty, int carId) {
            this.carProperty = carProperty;
            this.carId = carId;
        }

        @Override
        public int compareTo(CarProperty cp) {
            if (cp.carProperty > this.carProperty)
                return 1;
            if (cp.carProperty < this.carProperty)
                return -1;
            return Integer.compare(cp.carId, this.carId);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CarProperty that = (CarProperty) o;
            return carId == that.carId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(carId);
        }
    }

    public GarageImpl () {
        owners = new HashMap<Integer, Owner>();
        cars = new HashMap<Integer, Car>();
        ownercars = new HashMap<Owner, HashSet<Car>>();
        brandcars = new HashMap<String, HashSet<Car>>();
        carpowers = new TreeMap<CarProperty, Car>();
        carvelocities = new TreeMap<CarProperty, Car>();
        //hm2 = new HashMap<int, ArrayList<Car>>();
    }

    //набор уникальных владельцев всех машин, если я правильно понял условие
    public Collection<Owner> allCarsUniqueOwners() {
        return ownercars.keySet();
    }

    Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> topvelocity = new ArrayList<Car>();
        int topnum = 3; // кол-во машин в топе
        CarProperty key = carvelocities.firstKey();
        while (key != null && topvelocity.size() < topnum) {
            topvelocity.add(carvelocities.get(key));
            key = carvelocities.higherKey(key); // берем следующий ключ в мапе
        }
        return topvelocity;
    }

    public Collection<Car> allCarsOfBrand(String brand) {
        if(brandcars.containsKey(brand))
            return brandcars.get(brand);
        return new HashSet<Car>();
    }

    public Collection<Car> carsWithPowerMoreThan(int power) {
        //CarProperty testcp = new CarProperty(power, new Car)
        return carpowers.headMap(new CarProperty(power, Integer.MAX_VALUE)).values();
        //return new HashSet();
    }

    public Collection<Car> allCarsOfOwner(Owner owner) {
        if(ownercars.containsKey(owner))
            return ownercars.get(owner);
        return new HashSet<Car>();
    }

    public double meanOwnersAgeOfCarBrand(String brand) {
        double result = 0;
        Collection<Car> carsofbrand = allCarsOfBrand(brand);
        for (Car c : carsofbrand) {
            result += owners.get(c.getOwnerId()).getAge();
        }
        return result / carsofbrand.size();
    }

    public double meanCarNumberForEachOwner() {
        double result = 0;
        Set<Owner> keys = ownercars.keySet();
        for (Owner o : keys) {
            result += ownercars.get(o).size();
        }
        return result / keys.size();
    }

    public Car removeCar(int carId) {
        //cars:
        Car retcar = cars.remove(carId);
        if (retcar == null)
            return null;
        //ownercars:
        Owner keyowner = new Owner(retcar.getOwnerId());
        ownercars.get(keyowner).remove(new Car(carId));
        //если у владельца больше нет машин, удалить его из списка владельцев и мапа владелец - машина
        if (ownercars.get(keyowner).size() == 0) {
            ownercars.remove(keyowner);
            owners.remove(keyowner.getOwnerId());
        }
        //brandcars:
        String brand = retcar.getBrand();
        brandcars.get(brand).remove(new Car(carId));
        //carvelocities:
        carvelocities.remove(new CarProperty(retcar.getMaxVelocity(), carId));
        //carpowers:
        carpowers.remove(new CarProperty(retcar.getPower(), carId));
        return retcar;
    }

    public void addNewCar(Car car, Owner owner) {
        //owners:
        owners.put(owner.getOwnerId(), owner);
        //cars:
        cars.put(car.getCarId(), car);
        //ownercars:
        if (!ownercars.containsKey(owner)) {
            HashSet<Car> set = new HashSet<>();
            set.add(car);
            ownercars.put(owner, set);
        }
        else
            ownercars.get(owner).add(car);
        //brandcars:
        String brand = car.getBrand();
        if (!brandcars.containsKey(brand)) {
            HashSet<Car> set = new HashSet<>();
            set.add(car);
            brandcars.put(brand, set);
        }
        else
            brandcars.get(brand).add(car);
        //carvelocities:
        carvelocities.put(new CarProperty(car.getMaxVelocity(), car.getCarId()), car);
        //carpowers:
        carpowers.put(new CarProperty(car.getPower(), car.getCarId()), car);
    }
}