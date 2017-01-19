package logic.threads;

import data.ConfigReader;
import logic.ScoreTable;

import java.util.Random;

/**
 * Created by Oleg on 19.01.2017.
 */
public class TruckRaceThread implements Runnable {

    private Thread thread;
    private String name;
    private ConfigReader reader;
    private String type;

    private int circleLength;
    private int index;
    private int speed;
    private int propability;
    private int repTime;

    private static final int HOURS_TO_MINUTES = 60;


    private ScoreTable scoreTable;

    public TruckRaceThread(ConfigReader configReader, String vehicleType, int vehicleIndex, ScoreTable scoreTable) {

        thread = new Thread(this);
        System.out.println(thread.getName());

        this.reader = configReader;
        this.type = vehicleType;
        this.index = vehicleIndex;
        circleLength = configReader.getCircleLength();
        this.scoreTable = scoreTable;

        name = configReader.getTruckName(index);
        speed = configReader.getSpeedTruck(index);
        propability = configReader.getProbabilityWheelPunctureTruck(index);
        repTime = configReader.getTimeForReplacementWheelTruck(index);

        thread.start();

    }

    public Thread getThread(){
        return this.thread;
    }

    @Override
    public void run() {

        try {

            double passedDistance = 0;
            double distanceForMinute = (double) speed / HOURS_TO_MINUTES;
            int timeForReplaceWheel = reader.getTimeForReplacementWheelTruck(index);

            do {
                passedDistance += distanceForMinute;
                if (isPunchered()) {
                    System.out.println(name + " проехал " + passedDistance + "км");
                    System.out.println(name + ": прокол колеса!");
                    thread.sleep(timeForReplaceWheel * 1000);
                } else {
                    if (passedDistance >= circleLength) {
                        System.out.println(name + " гонку закончил.");
                        scoreTable.setTruckTimeCompleteRace(index, System.currentTimeMillis());
                    } else {
                        System.out.println(name + " проехал " + passedDistance + "км");
                        thread.sleep(1000);
                    }
                }

            } while (passedDistance < circleLength);
        } catch (InterruptedException ex) {
            System.out.println("Покатушка " + name + " сломалась! Ждем эвакуатор.");
        }

    }

    private boolean isPunchered() {
        boolean result = false;

        Random rand = new Random();
        int i = rand.nextInt(100);
        if (i <= propability) result = true;

        return result;
    }
}



