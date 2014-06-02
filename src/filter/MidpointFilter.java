package filter;

import java.util.Arrays;
import landscape.Landscape;

public class MidpointFilter extends LandFilter<Integer, Integer> {

    protected double R;
    protected int min;
    protected int max;

    public MidpointFilter(int seed, Getter<Integer> getter, Setter<Integer> setter) {
        super(seed, getter, setter);
        R = 0.5;
        min = -100;
        max = 100;
    }

    public Getter<Integer> constructGetter(Landscape land, Getter<Integer> getter) {
        return (a, b) -> {
            if (a > -1 && b > -1) {
                return getter.get(a, b);
            }
            if (a == -1 && b == 0) {
                return land.getWidth();
            }
            if (a == -1 && b == -1) {
                return land.getHeight();
            }
            return null;
        };
    }

    @Override
    public void transform() {
        int width = getter.get(-1, 0);
        int height = getter.get(-1, -1);
        int hs[] = new int[4];
        for (int i = 0; i < 4; i++) {
            hs[i] = r.nextInt(max - min) - min;
        }
        setter.set(0, 0, hs[0]);
        setter.set(0, height, hs[1]);
        setter.set(width, height, hs[2]);
        setter.set(width, 0, hs[3]);
        int points = 0;
        while (points < width * height) {
            
        }
    }

    public double getRoughness() {
        return R;
    }

    public void setRoughness(double R) {
        this.R = R;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
