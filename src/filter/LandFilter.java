package filter;

import landscape.Landscape;

public abstract class LandFilter<G, S> {

    protected Getter<G> getter;
    protected Setter<S> setter;
    protected int seed;

    abstract public Landscape transform(Landscape land);

    LandFilter(int seed, Getter<G> getter, Setter<S> setter) {
        this.seed = seed;
        this.getter = getter;
        this.setter = setter;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}
