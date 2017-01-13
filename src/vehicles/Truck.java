package vehicles;

import data.ConfigReader;

/**
 * Created by Oleg on 13.01.2017.
 */
public class Truck {

    private int speed;
    private double probabilityWheelPuncture;
    private int timeForReplacementWheels;
    private int cargoWeight;

    public Truck(ConfigReader configReader) {

        this.speed = configReader.getSpeedTruck();
        this.probabilityWheelPuncture = configReader.getProbabilityWheelPunctureTruck();
        this.timeForReplacementWheels = configReader.getTimeForReplacementWheelsTruck();
        this.cargoWeight = configReader.getCargoWeight();

    }

    public int getSpeed() {
        return this.speed;
    }

    public double getProbabilityWheelPuncture() {
        return this.probabilityWheelPuncture;
    }

    public int getTimeForReplacementWheels() {
        return this.timeForReplacementWheels;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }
}
