package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Oleg on 13.01.2017.
 */
public class ConfigReader {

    //количество мотоциклов, автомобилей, грузовиков
    private int quantityMoto, quantityAuto, quantityTruck;
    //длина гоночного круга
    private int circleLength;
    //названия мотоциклов, автомобилей, грузовиков
    private String[] motoName, autoName, truckName;
    //вероятность прокола колеса
    private int[] probabilityWheelPunctureMoto, probabilityWheelPunctureAuto, probabilityWheelPunctureTruck;
    //количество пассажиров в легковом авто, вес груза в грузовике
    private int[] numberOfPassengers, cargoWeight;
    //наличие коляски на мотоцикле
    private boolean[] availabilitySidecar;
    //время замены колеса
    private int[] timeForReplacementWheelMoto, timeForReplacementWheelAuto, timeForReplacementWheelTruck;

    //типы
    private static String TYPE_MOTO, TYPE_AUTO, TYPE_TRUCK;



    public ConfigReader() {

        try {
            Properties props = new Properties();
            props.load(new FileInputStream(new File("config/vehicle_config.ini")));

            circleLength = Integer.parseInt(props.getProperty("db.circleLength"));

            TYPE_MOTO = props.getProperty("db.vehicleType.0");
            TYPE_AUTO = props.getProperty("db.vehicleType.1");
            TYPE_TRUCK = props.getProperty("db.vehicleType.2");

            quantityMoto = Integer.parseInt(props.getProperty("db.quantityMoto"));
            quantityAuto = Integer.parseInt(props.getProperty("db.quantityAuto"));
            quantityTruck = Integer.parseInt(props.getProperty("db.quantityTruck"));

            initArrays(quantityMoto, quantityAuto, quantityTruck);




            for (int i = 0; i <quantityMoto; i++){
                motoName[i] = props.getProperty("db." + TYPE_MOTO + "." + i + "." + "name");
                probabilityWheelPunctureMoto[i] = Integer.parseInt(props.getProperty("db." + TYPE_MOTO + "." + i
                       + "." + "propabilityWheelPuncture"));
                availabilitySidecar[i] = Boolean.parseBoolean(String.valueOf(props.getProperty("db." + TYPE_MOTO + "." + i
                        + "." + "availabilitySidecar")));
                timeForReplacementWheelMoto[i] = Integer.parseInt(props.getProperty("db." + TYPE_MOTO + "." + i
                        + "." + "timeForReplacementWheel"));
                System.out.println(motoName[i] + "| ВПК: " + availabilitySidecar[i] + " | Наличие коляски: "
                 + availabilitySidecar[i] + " | Время на замену колеса: " + timeForReplacementWheelMoto[i]);
            }


            System.out.println();
            for (int i = 0; i <quantityAuto; i++){
                autoName[i] = props.getProperty("db." + TYPE_AUTO + "." + i + "." + "name");
                probabilityWheelPunctureAuto[i] = Integer.parseInt(props.getProperty("db." + TYPE_AUTO + "." + i
                        + "." + "propabilityWheelPuncture"));
                numberOfPassengers[i] = Integer.parseInt(props.getProperty("db." + TYPE_AUTO + "." + i
                        + "." + "numberOfPassengers"));
                timeForReplacementWheelAuto[i] = Integer.parseInt(props.getProperty("db." + TYPE_AUTO + "." + i
                        + "." + "timeForReplacementWheel"));
                System.out.println(autoName[i] + "| ВПК: " + probabilityWheelPunctureAuto[i] + " | К-во пассажиров: "
                 + numberOfPassengers[i] + " | Время на замену колеса: " + timeForReplacementWheelAuto[i]);
            }

            System.out.println();
            for (int i = 0; i <quantityTruck; i++){
                truckName[i] = props.getProperty("db." + TYPE_TRUCK + "." + i + "." + "name");
                probabilityWheelPunctureTruck[i] = Integer.parseInt(props.getProperty("db." + TYPE_TRUCK + "." + i
                        + "." + "propabilityWheelPuncture"));
                cargoWeight[i] = Integer.parseInt(props.getProperty("db." + TYPE_TRUCK + "." + i
                        + "." + "cargoWeight"));
                timeForReplacementWheelTruck[i] = Integer.parseInt(props.getProperty("db." + TYPE_TRUCK + "." + i
                        + "." + "timeForReplacementWheel"));
                System.out.println(truckName[i] + "| ВПК: " + probabilityWheelPunctureTruck[i] + " | Вес груза: "
                        + cargoWeight[i] + " | Время на замену колеса: " + timeForReplacementWheelTruck[i]);
            }




        } catch (IOException ex){
            System.err.println("ERROR: Configuration file does not exist!");
        }


    }

    private void initArrays(int quantityMoto, int quantityAuto, int quantityTruck) {

        //Названия покатушек
        motoName = new String[quantityMoto];
        autoName = new String[quantityAuto];
        truckName = new String[quantityTruck];

        //вероятности прокола колеса
        probabilityWheelPunctureMoto = new int[quantityMoto];
        probabilityWheelPunctureAuto = new int[quantityAuto];
        probabilityWheelPunctureTruck = new int[quantityTruck];

        availabilitySidecar = new boolean[quantityMoto];
        numberOfPassengers = new int[quantityAuto];
        cargoWeight = new int[quantityTruck];

        timeForReplacementWheelMoto = new int[quantityMoto];
        timeForReplacementWheelAuto = new int[quantityAuto];
        timeForReplacementWheelTruck = new int[quantityTruck];

    }

    private void init(){

    }



    /*

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

    public int getQuantityMoto(){
        return this.QUANTITY_MOTO;
    }

    public int getQuantityAuto(){
        return this.QUANTITY_AUTO;
    }

    public int getQuantityTruck(){
        return this.QUANTITY_TRUCK;
    }

    public int getCircleLength(){
        return this.getCircleLength();
    }
    */

}
