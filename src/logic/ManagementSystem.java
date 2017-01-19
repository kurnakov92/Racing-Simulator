package logic;

import data.ConfigReader;
import logic.threads.AutoRaceThread;
import logic.threads.MotoRaceThread;
import logic.threads.TruckRaceThread;

/**
 * Created by Oleg on 12.01.2017.
 */
public class ManagementSystem {

    private ConfigReader reader;

    private static final String TYPE_MOTO = "moto";
    private static final String TYPE_AUTO = "auto";
    private static final String TYPE_TRUCK = "truck";

    private long startTime;
    private ScoreTable scoreTable;

    private int motoQuantity;
    private int autoQuantity;
    private int truckQuantity;

    private MotoRaceThread[] motoRaceThreads;
    private AutoRaceThread[] autoRaceThreads;
    private TruckRaceThread[] truckRaceThreads;

    //TODO SINGLETONE
    public static void main(String[] args) {

        ManagementSystem ms = new ManagementSystem();
        System.out.println(Thread.currentThread());
        ms.init();
        ms.startRace();
        ms.joinThreads();
        ms.scoreTable.showScoretable();
        System.out.println("Запустить еще одну гонку?");

    }

    private void joinThreads() {

        for (int i = 0; i < motoQuantity; i++) {

            try {
                motoRaceThreads[i].getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int i = 0; i < autoQuantity; i++) {

            try {
                autoRaceThreads[i].getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int i = 0; i < truckQuantity; i++) {

            try {
                truckRaceThreads[i].getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void startRace() {

        printParameters();
        startTime = System.currentTimeMillis();
        scoreTable.setStartTime(startTime);
        startRaceMoto();
        startRaceAuto();
        startRaceTruck();

    }


    private void startRaceMoto() {
        for (int i = 0; i < motoQuantity; i++) {
            motoRaceThreads[i] = new MotoRaceThread(reader, TYPE_MOTO, i, scoreTable);
        }
    }

    private void startRaceAuto() {
        for (int i = 0; i < autoQuantity; i++) {
            autoRaceThreads[i] = new AutoRaceThread(reader, TYPE_AUTO, i, scoreTable);
        }
    }

    private void startRaceTruck() {
        for (int i = 0; i < truckQuantity; i++) {
            truckRaceThreads[i] = new TruckRaceThread(reader, TYPE_TRUCK, i, scoreTable);
        }
    }

    private void printParameters() {


        System.out.println("Мотоциклы: ");
        for (int i = 0; i < reader.getQuantity(TYPE_MOTO); i++) {
            System.out.println(reader.getMotoName(i) + "\n\t Вероятность прокола колеса: " + reader.getProbabilityWheelPunctureMoto(i)
                    + "%" + " \n\t Наличие коляски: "
                    + reader.getAvailabilitySidecar(i) + " \n\t Время на замену колеса: " + reader.getTimeForReplacementWheelMoto(i)
                    + " мин" + " \n\t Скорость: " + reader.getSpeedMoto(i) + " км/ч");
        }

        System.out.println();
        System.out.println("Автомобили: ");
        for (int i = 0; i < reader.getQuantity(TYPE_AUTO); i++) {
            System.out.println(reader.getAutoName(i) + "\n\t Вероятность прокола колеса: " + reader.getProbabilityWheelPunctureAuto(i)
                    + "%" + " \n\t Кол-во людей в машине: "
                    + reader.getNumberOfPassangers(i) + " \n\t Время на замену колеса: " + reader.getTimeForReplacementWheelAuto(i)
                    + " мин" + " \n\t Скорость: " + reader.getSpeedAuto(i) + " км/ч");
        }

        System.out.println();
        System.out.println("Грузовики: ");
        for (int i = 0; i < reader.getQuantity(TYPE_TRUCK); i++) {
            System.out.println(reader.getTruckName(i) + "\n\t Вероятность прокола колеса): " +
                    reader.getProbabilityWheelPunctureTruck(i) + "%" + " \n\t Вес груза: "
                    + reader.getCargoWeight(i) + " кг" + " \n\t Время на замену колеса: " + reader.getTimeForReplacementWheelTruck(i)
                    + " мин" + " \n\t Скорость: " + reader.getSpeedTruck(i) + " км/ч");
        }

    }

    //инициализация
    private void init() {

        reader = new ConfigReader();
        scoreTable = new ScoreTable(reader);
        motoQuantity = reader.getQuantity(TYPE_MOTO);
        autoQuantity = reader.getQuantity(TYPE_AUTO);
        truckQuantity = reader.getQuantity(TYPE_TRUCK);
        motoRaceThreads = new MotoRaceThread[motoQuantity];
        autoRaceThreads = new AutoRaceThread[autoQuantity];
        truckRaceThreads = new TruckRaceThread[truckQuantity];

    }

}
