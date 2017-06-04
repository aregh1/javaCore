package arrayintro;

/**
 * Created by Areg on 2/18/2017.
 */
public class TwoDimensionalArrays {

    public static void main(String[] args) {

//        double[][] doubles = new double[3][4];
//        double[][] doubles = new double[][2]; // compile error

        int[][] ints = new int[5][];
        int i = 0;
        for (; i < ints.length; i++) {
            ints[i] = new int[i + 1];
//            for (int j = 0; j < ints[i].length; j++) {
//                ints[i][j] = i;
//            }
        }

        print(ints);

        ints = new int[3][4];

        for ( i = 0; i < ints.length; i++){
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = i;
            }
        }

        System.out.println();
        print(ints);

    }


    static void print(int[][] d) {
        if (d == null) {
            System.out.println(d);
        } else {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    System.out.print(d[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}
