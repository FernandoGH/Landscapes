package landscape;

import filter.Getter;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;
import javax.imageio.ImageIO;

public class Writer {

    private File file;

    public Writer(File f) {
        file = f;
    }

    void RenderFunc(Function<Integer, Integer> data, Getter<Integer> getter) throws IOException {
        BufferedImage buf = new BufferedImage(data.apply(0), data.apply(1), BufferedImage.TYPE_INT_RGB);
        double l;
        if (data.apply(3) - data.apply(2) > 255) {
            l = (data.apply(3) - data.apply(2)) / 255.0;
        } else {
            l = 255.0 / (data.apply(3) - data.apply(2));
        }
        for (int i = 0; i < data.apply(0); i++) {
            for (int j = 0; j < data.apply(1); j++) {
                int c;
                if (l != 0) {
                    c = (int) ((getter.get(i, j) - data.apply(2)) / l);
                } else {
                    c = 0;
                }
                try {
                    buf.setRGB(i, j, new Colour(c, c, c).getRGB());
                } catch (Exception e) {
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("c = " + c);
                    System.out.println("l = " + l);
                    System.out.println(getter.get(i, j));
                    System.out.println("Stack Trace: ");
                    throw e;
                }
            }
        }
        ImageIO.write(buf, "bmp", file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
