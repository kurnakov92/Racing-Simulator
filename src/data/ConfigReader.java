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

    //типы покатушек
    private static String TYPE_MOTO, TYPE_AUTO, TYPE_TRUCK;

    public ConfigReader() {

        try {

            Properties props = new Properties();
            props.load(new FileInputStream(new File("config/vehicle_config.ini")));

            initVariables(props);
            initArrays(quantityMoto, quantityAuto, quantityTruck);
            loadDataFromFile(props);

        } catch (IOException ex){
            System.err.println("ERROR: Configuration file does not exist!");
        }

    }

    private void initVariables(Properties props) {

        circleLength = Integer.parseInt(props.getProperty("db.circleLength"));

        TYPE_MOTO = props.getProperty("db.vehicleType.0");
        TYPE_AUTO = props.getProperty("db.vehicleType.1");
        TYPE_TRUCK = props.getProperty("db.vehicleType.2");

        quantityMoto = Integer.parseInt(props.getProperty("db.quantityMoto"));
        quantityAuto = Integer.parseInt(props.getProperty("db.quantityAuto"));
        quantityTruck = Integer.parseInt(props.getProperty("db.quantityTruck"));

    }

    private void loadDataFromFile(Properties props) {

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

    public int getCircleLength(){
        return this.circleLength;
    }

    public int getQuantity(String str){
        int quantity = 0;

        if ("moto".equals(str)) {
            quantity = quantityMoto;
        } else if ("auto".equals(str)){
            quantity = quantityAuto;
        } else if ("truck".equals(str)){
            quantity = quantityTruck;
        }

        return quantity;
    }

    public String getMotoName(int index){
        return this.motoName[index];
    }

    public String getAutoName(int index){
        return this.autoName[index];
    }

    public String getTruckName(int index){
        return this.truckName[index];
    }

    public int getProbabilityWheelPunctureMoto(int index){
        return this.probabilityWheelPunctureMoto[index];
    }

    public int getProbabilityWheelPunctureAuto(int index){
        return this.probabilityWheelPunctureAuto[index];
    }

    public int getProbabilityWheelPunctureTruck(int index){
        return this.probabilityWheelPunctureTruck[index];
    }

    public int getNumberOfPassangers(int index){
        return this.numberOfPassengers[index];
    }

    public int getCargoWeight(int index){
        return this.cargoWeight[index];
    }

    public boolean getAvailabilitySidecar(int index){
        return this.availabilitySidecar[index];
    }

    public int getTimeForReplacementWheelMoto(int index){
        return this.timeForReplacementWheelMoto[index];
    }

    public int getTimeForReplacementWheelAuto(int index){
        return this.timeForReplacementWheelAuto[index];
    }

    public int getTimeForReplacementWheelTruck(int index){
        return this.timeForReplacementWheelTruck[index];
    }


}
