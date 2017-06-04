package bracechecker.util;

public interface Stack<T> {
    void push(T val);

    T pop();

    boolean isEmpty();

    void reset();
}