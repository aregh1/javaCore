package bracechecker.util;

public class StackInteger implements Stack<Integer> {
    private static final int DEFAULT_CAPACITY = 16;
    private Integer[] data;
    private int tos;

    public StackInteger() {
        this(DEFAULT_CAPACITY);
    }

    public StackInteger(int initialCapacity) {
        data = new Integer[initialCapacity];
        tos = -1;
    }

    @Override
    public void push(Integer value) {
        if (tos >= data.length) {
            ensureCapacity();
        }
        data[++tos] = value;
    }

    public Integer pop() {
        if (tos < 0) {
            return 0;
        }

        return data[tos--];
    }

    @Override
    public boolean isEmpty() {
        return tos == -1;
    }

    @Override
    public void reset() {
        for (int i = 0; i <= tos ; i++) {
            data[i] = null;
        }
        tos = -1;
        //TODO implement
    }

    private void ensureCapacity() {
        Integer[] newData = new Integer[data.length * 3 / 2 + 1];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }//todo convert to system array copy
        data = newData;
    }

}


