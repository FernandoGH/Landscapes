package landscape;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.imageio.ImageIO;

public class Try {

    public static void main(String[] args) throws IOException {
        int height = 256;
        int width = 2048;
        int seed = 1997;
        double R = 0.3;
        Point a = new Point(0, height/2);
        Point b = new Point(width - 1, height/2);
        ArrayList<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        Random r = new Random(seed);
        while (points.size() < width/2) {
            int i = 0;
            Point p1 = points.get(0);
            int n = points.size();
            while (points.size() < n + n - 1) {
                i++;
                Point p2 = points.get(i);
                int x = (p1.x + p2.x) / 2;
                int sign = r.nextBoolean() ? 1 : -1;
                sign *= r.nextBoolean() ? 1 : 0;
                double L = p1.distance(p2);
                L*=R;              
                int y = (p1.y + p2.y) / 2 + r.nextInt((int)L+1) * sign;
                Point p3 = new Point(x, y);
                points.add(i, p3);
                p1 = p2;
                i++;
            }
        }
        BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Iterator<Point> itera = points.iterator();
        Point p = itera.next();
        Graphics2D g = buf.createGraphics();
        while (itera.hasNext()) {

            Point p1 = itera.next();
            g.drawLine(p.x, p.y, p1.x, p1.y);
            p = p1;
        }
        ImageIO.write(buf, "bmp", new File("Center.bmp"));

    }

}
