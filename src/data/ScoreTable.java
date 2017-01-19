package data;

import java.util.*;

/**
 * Created by Oleg on 18.01.2017.
 */
public class ScoreTable {

    private long startTime = 0;

    private int motoQuantity;
    private int autoQuantity;
    private int truckQuantity;

    private HashMap hashMap = new HashMap();

    private static final String TYPE_MOTO = "moto";
    private static final String TYPE_AUTO = "auto";
    private static final String TYPE_TRUCK = "truck";

    public ScoreTable(ConfigReader configReader) {

        motoQuantity = configReader.getQuantity(TYPE_MOTO);
        autoQuantity = configReader.getQuantity(TYPE_AUTO);
        truckQuantity = configReader.getQuantity(TYPE_TRUCK);
    }

    public void setMotoTimeCompleteRace(String vehicleName, long time) {
        this.hashMap.put(vehicleName, time);
    }

    public void setAutoTimeCompleteRace(String vehicleName, long time) {
        this.hashMap.put(vehicleName, time);
    }

    public void setTruckTimeCompleteRace(String vehicleName, long time) {
        this.hashMap.put(vehicleName, time);
    }

    public void setStartTime(long time) {
        this.startTime = time;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void showScoretable() {

        List<Map.Entry<String, Long>> entries = new ArrayList<Map.Entry<String, Long>>(hashMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> e1, Map.Entry<String, Long> e2) {
                long v1 = e1.getValue();
                long v2 = e2.getValue();
                return (v1 > v2) ? 1 : (v1 == v2) ? 0 : -1;
            }
        });

        System.out.println();
        System.out.println("Таблица первенства: ");
        System.out.println("___________________________________");
        int i = 1;
        for (Map.Entry<String, Long> e : entries) {
            System.out.printf("  %-3d  |    %-5s  ", i, e.getKey());
            System.out.println();
            i++;
        }
        System.out.println("___________________________________");
        System.out.println();

    }


}
