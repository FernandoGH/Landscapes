package filter;

@FunctionalInterface

public interface Getter<R> {
    R get(int a, int b);
}
