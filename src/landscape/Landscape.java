package landscape;

import filter.LandFilter;

public class Landscape {

    private int width;
    private int height;
    private int maxHeight;
    private int minHeight;
    private int maxMoist;
    private int minMoist;
    private Tyle[][] tyles;

    public Landscape(int wid, int heig) {
        tyles = new Tyle[wid][heig];
        width = wid;
        height = heig;
        for (int i = 0; i < wid; i++) {
            for (int j = 0; j < heig; j++) {
                tyles[i][j] = new Tyle();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tyle[][] getTyles() {
        return tyles;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void refresh() {
        int MxM = Integer.MIN_VALUE;
        int MnM = Integer.MAX_VALUE;
        int MxH = Integer.MIN_VALUE;
        int MnH = Integer.MAX_VALUE;
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                int m = getTyles()[i][j].getMoisture();
                int h = getTyles()[i][j].getHeight();
                if (m > MxM) {
                    MxM = m;
                }
                if (m < MnM) {
                    MnM = m;
                }
                if (h > MxH) {
                    MxH = h;
                }
                if (h < MnH) {
                    MnH = h;
                }
            }
        }
        maxHeight = MxH;
        minHeight = MnH;
        maxMoist = MxM;
        minMoist = MnM;
    }

    public Landscape applyFilter(LandFilter filter) {
        return filter.transform(this);
    }

    public int getMaxMoist() {
        return maxMoist;
    }

    public int getMinMoist() {
        return minMoist;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                s += tyles[i][j].getHeight();
            }
            s+="\n";
        }
        return s;
    }
}
