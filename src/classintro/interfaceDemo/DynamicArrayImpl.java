package classintro.interfaceDemo;

/**
 * Created by Areg on 4/16/2017.
 */
public class DynamicArrayImpl<T> implements DynamicArray<T> {
    private final int DEFAULT_CAPACITY = 15;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(T o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i + 1;
                }
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(T o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }

        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }

        }
        return -1;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        validation(true, index);
//        if (index < 0 || index >= size()) {
//            throw new DynamicArrayIndexOutOfBoundException(index);
//        }
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        validation(true, index);
//        if (index < 0 || index >= size()) {
//            throw new DynamicArrayIndexOutOfBoundException(index);
//        }
        T temp = (T) array[index];
        array[index] = element;
        return temp;
    }

    @Override
    public boolean add(T e) {
        ensureCapacity();
        array[size++] = e;
        return true;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        validation(false, index);
//        if (index < 0 || index > size()) {
//            throw new DynamicArrayIndexOutOfBoundException(index);
//        }
        ensureCapacity();
//        for (int i = size; i > index ; i--) {
//            array[i] = array[i-1];
//        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size = size + 1;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        validation(true, index);
//        if (index < 0 || index >= size()) {
//            throw new DynamicArrayIndexOutOfBoundException(index);
//        }
        T temp = (T) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return temp;
    }

    @Override
    public boolean remove(T o) {
        int i = indexOf(o);
        if (i > -1) {
            remove(i);
            return true;
        }
        return false;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            Object[] newData = new Object[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, newData, 0, array.length);
            array = newData;
        }
    }

    private void validation(boolean isIndexOfLastElementValid, int index) {
        if (isIndexOfLastElementValid) {
            if (index < 0 || index >= size()) {
                throw new DynamicArrayIndexOutOfBoundException(index);
            }

        } else {
            if (index < 0 || index > size()) {
                throw new DynamicArrayIndexOutOfBoundException(index);
            }

        }
    }
}// TODO: VAIDATION