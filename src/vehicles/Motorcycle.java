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

    public int getSpeed() {
        return this.speed;
    }

    public double getProbabilityWheelPuncture() {
        return this.probabilityWheelPuncture;
    }

    public int getTimeForReplacementWheels() {
        return this.timeForReplacementWheels;
    }

    public boolean getAvailabilitySidecar() {
        return this.availabilitySidecar;
    }

    public boolean isAvailabilitySidecar() {
        return this.availabilitySidecar;
    }

}
