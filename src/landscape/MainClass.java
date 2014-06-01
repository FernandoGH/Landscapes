package landscape;

import filter.*;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

public class MainClass {

    public static void main(String[] args) throws IOException {

        Landscape land = new Landscape(512, 512);

        Getter<Integer> getter = (a, b) -> {
            if (a == 1 && b == 1) {
                return 200;
            }
            if (a == -1 && b == -1) {
                return -55;
            }
            return 0;
        };
        Setter<Integer> setter = (a, b, h) -> land.getTyle(a, b).setHeight(h);
        RandomFill filter = new RandomFill(33, getter, setter);
        land.applyFilter(filter);
        Writer wr = new Writer(new File("try.bmp"));
        getter = (a, b) -> land.getTyle(a, b).getHeight();
        Function<Integer, Integer> data = (a) -> {
            if (a < 4) {
                return land.getDescrFunc().apply(a);
            }
            return null;
        };
        wr.RenderFunc(data, getter);
    }
}
