package landscape;

import java.awt.*;
import java.io.File;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Writer {

    private File file;

    public Writer(File f) {
        file = f;
    }

    void RenderHeightMap(Landscape data) throws IOException {
        BufferedImage buf = new BufferedImage(data.getWidth(), data.getHeight(), BufferedImage.TYPE_INT_RGB);
        double l;
        if (data.getMaxHeight() - data.getMinHeight() > 256) {
            l = (data.getMaxHeight() - data.getMinHeight()) / 256;
        } else {
            l = 256 / (data.getMaxHeight() - data.getMinHeight());
        }
        Tyle[][] tyles = data.getTyles();
        for (int i = 0; i < data.getWidth(); i++) {
            for (int j = 0; j < data.getHeight(); j++) {
                int c;
                if (l != 0) {
                    c = (int)((tyles[i][j].getHeight()-data.getMinHeight()) / l);
                } else {
                    c = 0;
                }
                buf.setRGB(i, j, new Colour(c, c, 255).getRGB());
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
