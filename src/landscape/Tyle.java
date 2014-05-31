package landscape;

public class Tyle {

    private int height;
    private int moisture;

    public Tyle() {
        height = 0;
        moisture = 0;
    }

    public Tyle(int m, int h) {
        moisture = m;
        height = h;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMoisture() {
        return moisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }
}
