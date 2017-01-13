package vehicles;

import data.ConfigReader;

/**
 * Created by Oleg on 13.01.2017.
 */
public class Auto {

    private int speed;
    private double probabilityWheelPuncture;
    private int timeForReplacementWheels;
    private int numberOfPassengers;

    public Auto(ConfigReader configReader) {

        this.speed = configReader.getSpeedAuto();
        this.probabilityWheelPuncture = configReader.getProbabilityWheelPunctureAuto();
        this.timeForReplacementWheels = configReader.getTimeForReplacementWheelsAuto();
        this.numberOfPassengers = configReader.getNumberOfPassangers();

    }
}
