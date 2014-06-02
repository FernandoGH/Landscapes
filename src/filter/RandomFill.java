package filter;

import landscape.Landscape;
import landscape.Tyle;

public class RandomFill extends LandFilter<Integer, Integer> {

    protected int min;
    protected int max;

    /**
     *
     * @param seed
     * @param getter (0,0) - width, (0, 1) - height.
     * @param setter
     */
    public RandomFill(int seed, Getter<Integer> getter, Setter<Integer> setter) {
        super(seed, getter, setter);
        min = -100;
        max = 100;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static Getter<Integer> constructGetter(Landscape land) {
        Getter<Integer> answer = (a, b) -> {
            if (a == 0 && b == 0) {
                return land.getWidth();
            }
            if (a == 0 && b == 1) {
                return land.getHeight();
            }
            return null;
        };
        return answer;
    }

    @Override
    public void transform() {
        for (int i = 0; i < getter.get(0, 0); i++) {
            for (int j = 0; j < getter.get(0, 1); j++) {
                setter.set(i, j, r.nextInt(Math.abs(getMin()) + Math.abs(getMax())) + getMin());
            }
        }
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
