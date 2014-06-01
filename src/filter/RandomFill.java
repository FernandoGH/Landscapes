package filter;

import java.util.Random;
import landscape.Landscape;
import landscape.Tyle;

public class RandomFill extends LandFilter<Integer, Integer> {

    final private int min;
    final private int max;
    protected final Random r;

    /**
     *
     * @param seed
     * @param getter от (-1, -1) возвращает min, от (1, 1) возвращает max.
     * @param setter
     */
    public RandomFill(int seed, Getter<Integer> getter, Setter<Integer> setter) {
        super(seed, getter, setter);
        min = getter.get(-1, -1);
        max = getter.get(1, 1);
        r = new Random(seed);
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
                setter.set(i, j, r.nextInt(Math.abs(min) + Math.abs(max)) + min);
            }
        }
        land.refresh();
        return land;
    }
}
