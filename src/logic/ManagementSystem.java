package logic;

import data.ConfigReader;
import vehicles.Auto;
import vehicles.Motorcycle;
import vehicles.Truck;

/**
 * Created by Oleg on 12.01.2017.
 */
public class ManagementSystem {

    private Truck truck;
    private Auto auto;
    private Motorcycle motorcycle;

    //TODO SINGLETONE
    public static void main(String[] args) {

        ManagementSystem ms = new ManagementSystem();
        ms.initClasses();

    }

    //инициализация классов
    private void initClasses() {

        ConfigReader configReader = new ConfigReader();
        truck = new Truck(configReader);
        auto = new Auto(configReader);
        motorcycle = new Motorcycle(configReader);

    }
}
