package draft;

import util.ArrayUtil;

public class Draft {
    public static void main(String[] args) {
        varargs();
    }

    static void varargs(int ... v){
        System.out.println(v);
    }

    public static void  sortByOdddAndEven(int[] a) {
        System.out.println("hwebff");
    }

    static int[] reversee(int[] array) {
        int lenght = array.length;
        int lastIndex = array.length - 1;
        int b;
        int[] reverse = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            reverse[i] = array[lastIndex - i];
        }
        return reverse;
    }

    static int reverseNumber(int i) {
        int res = 0;
        for (; i > 0; i /= 10) {
            res = 10 * res + i % 10;
        }
        return res;
    }

    static void print(int[] a, String delimiter) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + delimiter);
        }
        System.out.println();
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}









