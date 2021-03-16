package ru.sber.reportGenerator.program;

import ru.sber.garage.*;
import ru.sber.reportGenerator.Report;
import ru.sber.reportGenerator.ReportExcelGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("I work!");
        Garage garage = new GarageImpl();
        Owner owner1 = new Owner(1, "John", "Wick", 35);
        Owner owner2 = new Owner(2, "Vasiliy", "Pupkin", 41);
        garage.addNewCar(new Car(1, "Boss", "429", 190, 200, 1), owner1);
        garage.addNewCar(new Car(2, "Lada", "2101", 60, 110, 2), owner2);
        garage.addNewCar(new Car(3, "Lada", "2106", 90, 120, 2), owner2);

        Collection<Owner> owners = garage.allCarsUniqueOwners();
        System.out.println("list of owners: " + owners);

        ReportExcelGenerator<Owner> rg = new ReportExcelGenerator<>();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        try {
            Report report = rg.generate(new ArrayList<>(owners));
            try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) {
                report.writeTo(outputStream);
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException("Cannot acess file", e);
            }
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException("Could not access entity field", e);
        }
    }
}
