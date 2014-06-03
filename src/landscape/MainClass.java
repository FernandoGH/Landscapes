package landscape;

import filter.*;
import java.io.File;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        Landscape land = new Landscape(2048, 2048);
        land.getTyle(0, 0).setHeight(5);
        land.getTyle(3, 3).setHeight(33);
        land.getTyle(0, 3).setHeight(50);
        Getter<Integer> getter = MidpointFilter.constructGetter(land, (a, b) -> land.getTyle(a, b).getHeight());

        MidpointFilter filter = new NoisyMidpointFilter(33, getter, (a, b, c) -> land.getTyle(a, b).setHeight(c));
        filter.setRoughness(0.5);
        land.applyFilter(filter);
        
        System.out.println(land.getMaxHeight() + " " + land.getMinHeight());
        System.out.println("Delta: " + (land.getMaxHeight()-land.getMinHeight()));
        
        Writer wr = new Writer(new File("Mid.bmp"));
        wr.RenderFunc(land.getDescrFunc(), getter);
    }
}
