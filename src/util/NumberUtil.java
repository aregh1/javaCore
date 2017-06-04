package util;

/**
 * Created by Areg on 2/11/2017.
 */
public class NumberUtil {
    public static void main(String[] args) {
        System.out.println(revers(98694));

    }
    static int revers(int i) {
        int res = 0;
        for (; i > 0; i /= 10) {
            res = 10 * res + i % 10;
        }
        return res;
    }

}



