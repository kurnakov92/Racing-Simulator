package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Oleg on 13.01.2017.
 */
public class ConfigReader {

    //скорость мотоцикла
    private static int SPEED_MOTO;
    //скорость автомобиля
    private static int SPEED_AUTO;
    //скорость грузовика
    private static int SPEED_TRUCK;
    //вероятность прокола колеса мотоцикла
    private static double PROPABILITY_WHEEL_PUNCTURE_MOTO;
    //вероятность прокола колеса легкового автомобиля
    private static double PROPABILITY_WHEEL_PUNCTURE_AUTO;
    //вероятность прокола колеса грузовика
    private static double PROPABILITY_WHEEL_PUNCTURE_TRUCK;
    //время на замену колеса (мотоцикл)
    private static int TIME_FOR_REPLACEMENT_WHEELS_MOTO;
    //время на замену колеса (автомобиль)
    private static int TIME_FOR_REPLACEMENT_WHEELS_AUTO;
    //время на замену колеса (грузовик)
    private static int TIME_FOR_REPLACEMENT_WHEELS_TRUCK;
    //вес груза (для грузовых)
    private static int CARGO_WEIGHT;
    //количество пассажиров (для легковых)
    private static int NUMBER_OF_PASSENGERS;
    //наличие коляски (для мотоцикла)
    private static boolean AVAILABILITY_SIDECAR;


    public ConfigReader() {

        try {
            Properties props = new Properties();
            props.load(new FileInputStream(new File("config/vehicle_settings.ini")));
            SPEED_MOTO = Integer.parseInt(props.getProperty("db.speedMoto"));
            SPEED_AUTO = Integer.parseInt(props.getProperty("db.speedAuto"));
            SPEED_TRUCK = Integer.parseInt(props.getProperty("db.speedTruck"));
            PROPABILITY_WHEEL_PUNCTURE_MOTO = Double.parseDouble(props.getProperty("db.propabilityWheelPunctureMoto"));
            PROPABILITY_WHEEL_PUNCTURE_AUTO = Double.parseDouble(props.getProperty("db.propabilityWheelPunctureAuto"));
            PROPABILITY_WHEEL_PUNCTURE_TRUCK = Double.parseDouble(props.getProperty("db.propabilityWheelPunctureTruck"));
            TIME_FOR_REPLACEMENT_WHEELS_MOTO = Integer.parseInt(props.getProperty("db.timeForReplacementWheelsMoto"));
            TIME_FOR_REPLACEMENT_WHEELS_AUTO = Integer.parseInt(props.getProperty("db.timeForReplacementWheelsAuto"));
            TIME_FOR_REPLACEMENT_WHEELS_TRUCK = Integer.parseInt(props.getProperty("db.timeForReplacementWheelsTruck"));
            CARGO_WEIGHT = Integer.parseInt(props.getProperty("db.cargoWeight"));
            NUMBER_OF_PASSENGERS = Integer.parseInt(props.getProperty("db.numberOfPassengers"));
            AVAILABILITY_SIDECAR = Boolean.parseBoolean("db.availabilitySidecar");
        } catch (IOException ex){
            System.err.println("ERROR: Configuration file does not exist!");
        }


    }

    public int getSpeedMoto() {
        return this.SPEED_MOTO;
    }

    public int getSpeedAuto() {
        return this.SPEED_AUTO;
    }

    public int getSpeedTruck() {
        return this.SPEED_TRUCK;
    }

    public double getProbabilityWheelPunctureMoto() {
        return this.PROPABILITY_WHEEL_PUNCTURE_MOTO;
    }

    public double getProbabilityWheelPunctureAuto() {
        return this.PROPABILITY_WHEEL_PUNCTURE_AUTO;
    }

    public double getProbabilityWheelPunctureTruck() {
        return this.PROPABILITY_WHEEL_PUNCTURE_TRUCK;
    }

    public int getTimeForReplacementWheelsMoto(){
        return this.TIME_FOR_REPLACEMENT_WHEELS_MOTO;
    }

    public int getTimeForReplacementWheelsAuto(){
        return this.TIME_FOR_REPLACEMENT_WHEELS_AUTO;
    }

    public int getTimeForReplacementWheelsTruck(){
        return this.TIME_FOR_REPLACEMENT_WHEELS_TRUCK;
    }

    public int getCargoWeight() {
        return this.CARGO_WEIGHT;
    }

    public int getNumberOfPassangers() {
        return this.NUMBER_OF_PASSENGERS;
    }

    public boolean getAvailabilitySidecar() {
        return this.AVAILABILITY_SIDECAR;
    }
}
