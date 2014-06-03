package filter;

public class NoisyMidpointFilter extends MidpointFilter {

    public NoisyMidpointFilter(int seed, Getter<Integer> getter, Setter<Integer> setter) {
        super(seed, getter, setter);
    }

    @Override
    public void transform() {
        int width = getter.get(-1, 0);
        int height = getter.get(-1, -1);
        int points = 4;
        mx.add(getter.get(0, 0));
        mx.add(getter.get(height - 1, width - 1));
        mx.set(0, 1, getter.get(0, width - 1));
        mx.set(1, 0, getter.get(height - 1, 0));
        int l = (width + height) / 2;
        int hCons = 2;
        int wCons = 2;
        Setter<Integer> firstPoint;
        Setter<Integer> secondPoint;
        Setter<Integer> other = set;
        Getter<Integer> getDown; //Необходимо для поправки на появившуюся строчку

        while (points < width * height) {
            int a = 0;
            int b = 0;
            hCons = hCons * 2 - 1;
            wCons = wCons * 2 - 1;
            while (a < hCons - 1) {
                b = 0;
                while (b < wCons - 1) {
                    if (a == 0) {
                        firstPoint = addColumn;
                    } else {
                        firstPoint = set;
                    }
                    if (b == 0) {
                        secondPoint = addLine;
                        getDown = getNDown;
                    } else {
                        secondPoint = set;
                        getDown = getModDown;
                    }

                    int h = mx.get(a, b) + mx.get(a, b + 1);
                    h /= 2;
                    h += r.nextInt((int) (R * l * 2 + 1)) - (int) (R * l * +1);
                    firstPoint.set(a, b + 1, h);//point 1
                    points++;

                    h = mx.get(a, b + 2) + getDown.get(a + 1, b + 2);
                    h /= 2;
                    h += r.nextInt((int) (R * l * 2 + 1)) - (int) (R * l * +1);
                    secondPoint.set(a + 1, b + 2, h);//point 2
                    points++;

                    h = mx.get(a + 2, b + 2) + mx.get(a + 2, b);
                    h /= 2;
                    h += r.nextInt((int) (R * l * 2 + 1)) - (int) (R * l * +1);
                    other.set(a + 2, b + 1, h);//point 3
                    points++;

                    h = mx.get(a, b) + mx.get(a + 2, b);
                    h /= 2;
                    h += r.nextInt((int) (R * l * 2 + 1)) - (int) (R * l * +1);
                    other.set(a + 1, b, h);//point 4
                    points++;

                    h = mx.get(a, b) + mx.get(a, b + 2) + mx.get(a + 2, b + 2) + mx.get(a + 2, b);
                    h /= 4;
                    int noise = r.nextInt((int) (R * l * 2 + 1)) - (int) (R * l * +1);
                    h += noise;
                    other.set(a + 1, b + 1, h);//point 5 - center noisy point
                    points++;

                    b += 2;//move the counting square left;
                }
                a += 2;//move the counting square down;
            }
            l /= 2;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                setter.set(i, j, mx.get(i, j));
            }
        }
    }

}
