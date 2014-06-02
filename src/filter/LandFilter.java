package filter;

import java.util.Random;
import landscape.Landscape;

public abstract class LandFilter<G, S> {

    protected Getter<G> getter;
    protected Setter<S> setter;
    protected int seed;
    protected Random r;

    abstract public void transform();

    LandFilter(int seed, Getter<G> getter, Setter<S> setter) {
        this.seed = seed;
        this.getter = getter;
        this.setter = setter;
        r = new Random(seed);
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}
