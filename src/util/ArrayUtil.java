package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * This class contains utility methods for array
 * manipulation.
 */
public class ArrayUtil {
    /**
     * Creates an util filled with random values.
     *
     * @param length the length of the util
     * @param n      the number of possible random values
     * @return an util filled with length numbers between
     * 0 and n-1
     */
    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        Random generator = new Random();

        for (int i = 0; i < length; i++) {
            a[i] = generator.nextInt(n);
        }
        return a;
    }

    /**
     * Sorts the util elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the util
     */
    public static void sortByOddAndEven(int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            while ((a[i] + a[j]) % 2 == 0) {
                j++;
                if (j >= a.length) {
                    return;
                }
            }
            for (; (a[i] + a[j]) % 2 == 0; ) {
                j++;
                if (j >= a.length) {
                    return;
                }
            }

            if (i + 1 < j) {
                swap(a, i + 1, j);
            }
        }

    }


    public static int getMaximum(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;   // this must be replaced by correct code
    }


    public static int getMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }


    /**
     * Calculates the sum of specified <code>util</code>  elements
     *
     * @param array specified int util
     * @return the sum of the specified util elements
     */
    public static int getSum(int[] array) {
        int sum = 0;
        for (int current : array) {
            sum += current;
        }
        return sum;
    }


    /**
     * Creates the reversed to specified array new array and returns it.
     *
     * @param array an array corresponding to which must be created reversed array
     * @return new created reversed array to the specified parameter "array"
     */
    public static int[] reverse(int[] array) {
        int length = array.length;
        int lastIndex = array.length - 1;
        int[] reverse = new int[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = array[lastIndex - i];
        }

        return reverse;
    }

    /**
     * Reverses the elements order of the specified array
     *
     * @param array an array: Elements order of wich must be reversed
     */
    public static void reverseInSameArray(int[] array) {
        int count = array.length / 2;
        int lastIndex = array.length - 1;
        for (int i = 0; i < count; i++) {
            swap(array, i, lastIndex - i);
        }
    }

    /**
     * Swaps the elements at the specified positions in the specified array.
     * (If the specified positions are equal, invoking this method leaves
     * the array unchanged.)
     *
     * @param array The array in which to swap elements.
     * @param i     the index of one element to be swapped.
     * @param j     the index of the other element to be swapped.
     * @throws IndexOutOfBoundsException if either i or j
     *                                   is out of range (i < 0 || i >= array.length
     *                                   || j < 0 || j >= array.length).
     */
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void print(int[] a) {
        print(a, " ");
    }

    /**
     * Prints all elements in an array by using specified delimiter between elements.
     *
     * @param a the util to print
     */
    public static void print(int[] a, String delimiter) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + delimiter);
        }
        System.out.println();
    }


}
      
