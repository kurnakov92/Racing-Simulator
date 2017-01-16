package logic;

import data.ConfigReader;
import vehicles.Auto;
import vehicles.Motorcycle;
import vehicles.Truck;

/**
 * Created by Oleg on 12.01.2017.
 */
public class ManagementSystem {

    private ConfigReader configReader;

    private Truck[] truck;
    private Auto[] auto;
    private Motorcycle[] motorcycle;

    private static final String TYPE_MOTO = "moto";
    private static final String TYPE_AUTO = "auto";
    private static final String TYPE_TRUCK = "truck";


    //TODO SINGLETONE
    public static void main(String[] args) {

        ManagementSystem ms = new ManagementSystem();
        ms.init();
        
    }

    private void startRace() {

        startRaceMoto();

    }

    private void startRaceMoto() {

    }

    //инициализация
    private void init() {

        configReader = new ConfigReader();

    }


}
