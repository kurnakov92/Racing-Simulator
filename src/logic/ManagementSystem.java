package logic;

import data.ConfigReader;
import vehicles.Auto;
import vehicles.Motorcycle;
import vehicles.Truck;

/**
 * Created by Oleg on 12.01.2017.
 */
public class ManagementSystem {

    private Truck[] truck;
    private Auto[] auto;
    private Motorcycle[] motorcycle;

    private int motoQuantity = 0;
    private int autoQuantity;
    private int truckQuantity;


    //TODO SINGLETONE
    public static void main(String[] args) {

        ManagementSystem ms = new ManagementSystem();
        ms.init();
        ms.startRace();




    }

    private void startRace() {

        startRaceMoto();

    }

    private void startRaceMoto() {

        for ( int i = 0; i < motoQuantity; i++){
            System.out.println("Motorcycle № " + i + "; Speed = " + motorcycle[i].getSpeed() + "; Probability wheel " +
                    "puncture = " + motorcycle[i].getProbabilityWheelPuncture() + ";  Availability sidecar = " +
            motorcycle[i].getAvailabilitySidecar());
        }

    }

    //инициализация
    private void init() {

        ConfigReader configReader = new ConfigReader();
        motoQuantity = configReader.getQuantityMoto();
        autoQuantity = configReader.getQuantityAuto();
        truckQuantity = configReader.getQuantityTruck();

        motorcycle = new Motorcycle[motoQuantity];
        auto = new Auto[autoQuantity];
        truck = new Truck[truckQuantity];

        for (int i = 0;  i < motoQuantity; i++){
            motorcycle[i] = new Motorcycle(configReader);
        }

        for (int i = 0;  i < autoQuantity; i++){
            auto[i] = new Auto(configReader);
        }

        for (int i = 0;  i < truckQuantity; i++){
            truck[i] = new Truck(configReader);
        }

    }


}
