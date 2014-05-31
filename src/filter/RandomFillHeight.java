package filter;

import java.util.Random;
import landscape.Landscape;
import landscape.Tyle;

public class RandomFillHeight implements LandFilter{

    private int seed;
    private int min;
    private int max;
    Random r;

    public RandomFillHeight(int s, int mn, int mx) {
        r = new Random(s);
        min = mn;
        max = mx;
    }

    public RandomFillHeight(int mn, int mx) {
        r = new Random();
        min = mn;
        max = mx;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public Landscape transform(Landscape land) {
        Tyle[][] tyles = land.getTyles();
        for (int i = 0; i < land.getWidth(); i++) {
            for (int j = 0; j < land.getHeight(); j++) {
                tyles[i][j].setHeight(r.nextInt(Math.abs(min)+Math.abs(max))+min);
            }
        }
        land.refresh();
        return land;
    }
    
}
