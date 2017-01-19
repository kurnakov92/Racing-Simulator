package logic.threads;

import java.util.Random;

/**
 * Created by Oleg on 20.01.2017.
 * Этот класс нужен для того, чтобы не дублировать метод isPunctered
 */
public class RaceThread {

    public RaceThread() {
    }

    public boolean isPunchered(int propability) {
        boolean result = false;

        Random rand = new Random();
        int i = rand.nextInt(100);
        if (i <= propability) result = true;

        return result;
    }
}
