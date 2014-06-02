package utils;

import java.util.ArrayList;

public class Matrix<E> {

    private int x = 0;
    private int y = 0;
    private E def = null;
    private final ArrayList<ArrayList<E>> elements = new ArrayList<>();

    void add(int a, int b, E element) {
        x++;
        y++;
        ArrayList<E> line = new ArrayList<>();
        for (int i = 0; i < getX(); i++) {
            line.add(def);
        }
        line.set(b, element);
        elements.stream().forEach((l) -> l.add(b, def));
        elements.add(a, line);
    }

    void addLine(int a, int b, E element) {
        y++;
        ArrayList<E> line = new ArrayList<>();
        for (int i = 0; i < getX(); i++) {
            line.add(def);
        }
        line.set(b, element);
        elements.add(a, line);
    }

    void AddColumn(int a, int b, E element) {
        x++;
        elements.stream().forEach((l) -> l.add(b, null));
        elements.get(a).set(b, element);
    }

    void add(E element) {
        y++;
        ArrayList<E> line = new ArrayList<>();
        for (int i = 0; i < getY() - 1; i++) {
            line.add(def);
        }
        elements.add(line);
        x++;
        elements.stream().forEach((l) -> l.add(def));
        elements.get(getX() - 1).set(getY() - 1, element);
    }

    void set(int a, int b, E element) {
        elements.get(a).set(b, element);
    }

    E get(int a, int b) {
        return elements.get(a).get(b);
    }

    @Override
    public String toString() {
        String s = "";
        for (ArrayList<E> element : elements) {
            s += element.toString();
            s += "\n";
        }
        return s;
    }

    boolean isSquare() {
        return x == y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public E getDef() {
        return def;
    }

    public void setDef(E def) {
        this.def = def;
    }
}
