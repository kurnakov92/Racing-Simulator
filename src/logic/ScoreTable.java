package logic;

import data.ConfigReader;

/**
 * Created by Oleg on 18.01.2017.
 */
public class ScoreTable {

    private long startTime = 0;
    private ConfigReader reader;

    private int motoQuantity;
    private int autoQuantity;
    private int truckQuantity;

    private long[] motoTimeCompleteRace;
    private long[] autoTimeCompleteRace;
    private long[] truckTimeCompleteRace;

    private static final String TYPE_MOTO = "moto";
    private static final String TYPE_AUTO = "auto";
    private static final String TYPE_TRUCK = "truck";

    public ScoreTable(ConfigReader configReader){

        this.reader = configReader;
        motoQuantity = configReader.getQuantity(TYPE_MOTO);
        autoQuantity = configReader.getQuantity(TYPE_AUTO);
        truckQuantity = configReader.getQuantity(TYPE_TRUCK);


        motoTimeCompleteRace = new long[motoQuantity];
        autoTimeCompleteRace = new long[autoQuantity];
        truckTimeCompleteRace = new long[truckQuantity];



    }

    public void setMotoTimeCompleteRace(int index, long time){
        this.motoTimeCompleteRace[index] = time;
    }

    public void setAutoTimeCompleteRace(int index, long time){
        this.autoTimeCompleteRace[index] = time;
    }

    public void setTruckTimeCompleteRace(int index, long time){
        this.truckTimeCompleteRace[index] = time;
    }

    public void setStartTime(long time){
        this.startTime = time;
    }

    public void showScoretable(){

        for (int i = 0; i < motoQuantity; i++){
            System.out.println(motoTimeCompleteRace[i]);
        }

        for (int i = 0; i < autoQuantity; i++){
            System.out.println(autoTimeCompleteRace[i]);
        }

        for (int i = 0; i < truckQuantity; i++){
            System.out.println(truckTimeCompleteRace[i]);
        }

    }

}
