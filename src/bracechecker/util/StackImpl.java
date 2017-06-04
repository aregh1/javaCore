package bracechecker.util;

/**
 * Created by Areg on 4/8/2017.
 */
public class StackImpl<E> implements Stack<E> {
    private Object[] data;
    private int tos;

    public StackImpl() {
        this(16);
    }

    public StackImpl(int initialCapacity) {
        tos = -1;
        data = new Object[initialCapacity];
    }

    @Override
    public void push(E value) {
        if (tos >= data.length - 1) {
            ensureCapacity();
        }
        data[++tos] = value;
    }

    @Override
    public E pop() {
        if (tos < 0) {
            return null;
        }
        E res = (E) data[tos];
        data[tos--] = null;
        return res;
    }

    @Override
    public boolean isEmpty() {
        return tos == -1;
    }

    @Override
    public void reset() {
        for (int i = 0; i <= tos; i++) {
            data[i] = null;
        }
        tos = -1;

    }

    private void ensureCapacity() {
        Object[] newData = new Object[data.length * 3 / 2 + 1];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }//todo convert to system array copy
        data = newData;
    }
//    todo check tos >= data.length - 1
}
