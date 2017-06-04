package classintro.interfaceDemo;

/**
 * Created by Areg on 4/16/2017.
 */
public class DynamicArrayIndexOutOfBoundException extends ArrayIndexOutOfBoundsException {
    public DynamicArrayIndexOutOfBoundException() {
        super();
    }

    public DynamicArrayIndexOutOfBoundException(int index) {
        super(index);
    }

    public DynamicArrayIndexOutOfBoundException(String s) {
        super(s);
    }
}
