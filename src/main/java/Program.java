import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        System.out.println("I work!");

        /*Set<Car> set = new HashSet();
        set.add(new Car(1234, "Lada", "VAZ2101", 80, 100, 12));
        set.add(new Car(1454, "Lada", "VAZ2106", 90, 120, 24));
        System.out.println(set.size());
        for (Car o : set) {
            System.out.println(o);
        }*/

        MyGarage garage = new MyGarage();
        garage.addNewCar(new Car(1, "Lada", "2101", 70, 100, 1), new Owner(1, "a", "b", 21));
        garage.addNewCar(new Car(2, "Lada", "2101", 60, 110, 2), new Owner(2, "a", "b", 23));
        garage.addNewCar(new Car(3, "Lada", "2101", 90, 120, 2), new Owner(2, "a", "b", 23));
        //garage.removeCar(1);

        System.out.println("garage: " + garage.cars);

        //Collection<Car> carsofbrand = garage.allCarsOfBrand("Lada");
        //System.out.println("all Lada cars: " + carsofbrand);

        //System.out.println("meanOwnersAgeOfCarBrand=" + garage.meanOwnersAgeOfCarBrand("Lada"));

        //Collection<Car> carsofowner = garage.allCarsOfOwner(new Owner(1));
        //System.out.println("cars of 1 owner: " + carsofowner);

        //Collection<Owner> owners = garage.allCarsUniqueOwners();
        //System.out.println("list of owners: " + owners);

        //Collection<Car> cartopvelocities = garage.topThreeCarsByMaxVelocity();
        //System.out.println("cars sorted by v: " + cartopvelocities);

        int power = 100;
        Collection<Car> carsmorepower = garage.carsWithPowerMoreThan(power);
        System.out.println("cars with power more than " + power + " : " + carsmorepower);

        //System.out.println(garage.meanCarNumberForEachOwner());
        /*for (Car o : carsofowner) {
            System.out.println(o);
        }*/
    }
}
