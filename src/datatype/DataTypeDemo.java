package datatype;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Areg on 1/31/2017.
 */
public class DataTypeDemo {

    public static void main(String[] args) {
//        charDemo();
//        longDemo();
        byteShortDemo();
//        floatDoubleDemo();
    }

    static void charDemo() {
        char c = '@';
        c = '\n';   // \t, \r,
        c = (char) ('\u0023' + c);
        c = 1 + 2;
        System.out.println(c);


        for (char ch = 32; ch < 127; ch++) {
            System.out.println((int) ch + " = " + ch);
        }
    }

    static void floatDoubleDemo() {
        float a = .1f;
        double d = .1D;
        for (double i = 0.1; ; i = i + 0.1) {

            if (i == 1) break;
            System.out.println(i);
        }
    }

    static void byteShortDemo() {
        long a = 32768;
        float b = 2;
        b = a;
       // a = (long) b;
//        char c = 32768;
        char c = (char)(byte) a;


    }

    static void longDemo() {
        long a = 0x7FFFFFFFL;
        System.out.println(a);
        int b = (int) a;
        System.out.println(b);
    }

}


