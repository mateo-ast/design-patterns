package design.patterns.behavioral.iterator;

public interface Iterador<T> {
    boolean hasNext();
    T next();
    void reset();
}
