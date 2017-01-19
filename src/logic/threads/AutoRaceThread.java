package logic.threads;

import data.ConfigReader;
import data.ScoreTable;

/**
 * Created by Oleg on 19.01.2017.
 */
public class AutoRaceThread extends RaceThread implements Runnable {

    private Thread thread;
    private String name;
    private ConfigReader reader;

    private int circleLength;
    private int index;
    private int speed;
    private int puncturePropability;

    private static final int HOURS_TO_MINUTES = 60;

    private ScoreTable scoreTable;

    public AutoRaceThread(ConfigReader configReader, int vehicleIndex, ScoreTable scoreTable) {

        thread = new Thread(this);

        this.reader = configReader;
        this.index = vehicleIndex;
        circleLength = configReader.getCircleLength();
        this.scoreTable = scoreTable;

        name = configReader.getAutoName(index);
        speed = configReader.getSpeedAuto(index);
        puncturePropability = configReader.getProbabilityWheelPunctureAuto(index);

        thread.start();
    }

    public Thread getThread() {
        return this.thread;
    }

    @Override
    public void run() {


        try {

            double passedDistance = 0;
            double distanceForMinute = (double) speed / HOURS_TO_MINUTES;
            int timeForReplaceWheel = reader.getTimeForReplacementWheelAuto(index);

            do {
                passedDistance += distanceForMinute;
                if (isPunchered(puncturePropability)) {
                    System.out.println(name + " проехал " + passedDistance + "км");
                    System.out.println(name + ": прокол колеса!");
                    thread.sleep(timeForReplaceWheel * 1000);
                } else {
                    if (passedDistance >= circleLength) {
                        System.out.println(name + " гонку закончил.");
                        scoreTable.setAutoTimeCompleteRace(name, System.currentTimeMillis() - scoreTable.getStartTime());
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
}
