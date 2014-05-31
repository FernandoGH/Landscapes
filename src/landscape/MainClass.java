package landscape;

import filter.RandomFillHeight;
import java.io.File;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        RandomFillHeight filter = new RandomFillHeight(33, -128, 127);
        Landscape land = new Landscape(512, 512);
        land.applyFilter(filter);
        Writer wr = new Writer(new File ("try.bmp"));
        wr.RenderHeightMap(land);
    }
}
