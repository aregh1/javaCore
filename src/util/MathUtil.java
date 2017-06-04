package util;


public class MathUtil {
    public static void main(String[] args) {
        moveHanoiTowerDisks(8, 1, 2, 3);
//        System.out.print(gcdByRec(32, 24));
//        System.out.print(powByRec(2,8));
//        System.out.print(towerOfHanoi(4, 1, 2, 3));
//        System.out.println(factorialByRec(3));
//        System.out.print(pow(2, 2));
//        System.out.print(factorial(4));
//        System.out.print(abs(-67));
//        System.out.print(reverse(655));
//        printIntAsBinary(88794);
//        System.out.print(gcd(48, 28));
//        System.out.print(pow(2, -3));
    }

    /**
     * Returns the value of the first argument raised to the power of the
     * second argument, such that a > 0 and n > 0.
     *
     * @param a the base
     * @param n the exponent
     * @return the value <code>a<sup>b</sup></code>.
     */
    public static double pow(int a, int n) {
        return n < 0 ? 1 / pow0(a, n) : pow0(a, n);
    }

    private static double pow0(int a, int n) {
        if (n == 0) {
            return a == 0 ? 0 : 1;
        }
        n = abs(n);
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow *= a;
        }
        return pow;
    }

    public static double powByRec(int a, int n) {
        if (n == 1) {
            return a;
        }
        return powByRec(a, n - 1) * a;
    }

    /**
     * Calculates and returns Greatest common divisor
     *
     * @param x
     * @param y
     * @return gcd of specified x and y numbers
     */
    public static int gcd(int x, int y) {
        while (x % y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return y;
    }

    public static void gcdByRecMain(int x, int y) {
        x = abs(x);
        y = abs(y);
        gcdByRec(x, y);
    }

    private static int gcdByRec(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcdByRec(y, x % y);
    }
//todo check positive and negative

    /**
     * Calculates and returns the factorial of specified n number
     *
     * @param n the number factorial of which must be calculated
     * @return calculated number
     */
    public static int factorial(int n) {
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac = fac * i;
        }
        return fac;
    }

    public static long factorialByRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return factorialByRec(n - 1) * n;
    }

    /**
     * Calculates and returns the absolute value
     * of specified n number
     *
     * @param n specified number to find the absolute number
     * @return absolute number of specified n
     */
    public static int abs(int n) {
        return n > 0 ? n : -n;
    }

    public static void printIntAsBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(n >> i & 1);
            if (i % 8 == 0) {
                System.out.print("");
            }
        }

    }

    public static int reverse(int number) {
        int a = 0;
        for (int i = number; i > 0; i /= 10) {
            a = 10 * a + i % 10;
        }
        return a;
    }

    public static void moveHanoiTowerDisks(int n, int first, int second, int third) {
        if (n == 1) {
            System.out.println(first + " --> " + third);
        } else {
            moveHanoiTowerDisks(n - 1, first, third, second);
            System.out.println(first + " --> " + third);
            moveHanoiTowerDisks(n - 1, second, first, third);
        }

    }


}
