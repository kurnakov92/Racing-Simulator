package vehicles;

import data.ConfigReader;

/**
 * Created by Oleg on 13.01.2017.
 */
public class Motorcycle {

    private int speed;
    private double probabilityWheelPuncture;
    private int timeForReplacementWheels;
    private boolean availabilitySidecar;

    public Motorcycle(ConfigReader configReader) {

        this.speed = configReader.getSpeedMoto();
        this.probabilityWheelPuncture = configReader.getProbabilityWheelPunctureMoto();
        this.timeForReplacementWheels = configReader.getTimeForReplacementWheelsMoto();
        this.availabilitySidecar = configReader.getAvailabilitySidecar();

    }
}
