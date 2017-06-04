package draft;

/**
 * Created by Areg on 3/21/2017.
 */
public class StackSecond {
    private int[] data;
    private int tos;
    private static final int DEFAULTCAPACITY = 16;

    public StackSecond() {
        this(DEFAULTCAPACITY);
    }

    public StackSecond(int initialCapacity) {
        data = new int[initialCapacity];
        tos = -1;
    }

    public void push(int value) {
        if (tos >= data.length) {
            ensureCapacity();
        }
        data[++tos] = value;
    }

    private void ensureCapacity() {
        int[] a = new int[data.length * (3 / 2) + 1];
        for (int i = 0; i < data.length; i++) {
            a[i] = data[i];
        }
        data = a;
    }
    public int pop(){
        if(tos < 0 ){
            return 0;
        }
        return data[tos--];
    }

}
