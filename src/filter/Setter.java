package filter;

@FunctionalInterface
public interface Setter<R> {
    void set(int a, int b, R data);
}
