package loops;


import sun.font.FontRunIterator;

public class FigurePrinter {


    /**
     * Draws the triangle by specified length number
     * for example when n = 4 , it must be such as
     * drawn below :
     * *
     * * *
     * * * *
     * * * * *
     *
     * @param length of triangle will be drawn
     */
    public static void drawLeftUpTriangle(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }

    }

    /**
     * Draws the triangle by specified length number
     * for example when n = 4 , it must be such as
     * drawn below :
     * *
     * * *
     * * * *
     * * * * *
     *
     * @param length specified length of triangle will be drawn
     */
    public static void drawRightUpTriangle(int length) {
        for (int i = 1; i <= length ; i++) {
            int j = 1;
            for (; j <= length - i ; j++) {
                System.out.print(" ");
            }
            for (; j <= length ; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }


    /**
     * Draws the triangle by specified length number
     * for example when n = 4 , it must be such as
     * drawn below :
     * <p>
     * * * * *
     * * * *
     * * *
     * *
     *
     * @param length specified length of triangle will be drawn
     */
    public static void drawLeftBottomTriangle(int length) {

    }

    /**
     * Draws the triangle by specified length number
     * for example when n = 4 , it must be such as
     * drawn below :
     * <p>
     * * * * *
       * * * *
         * * *
           * *
             *
     * @param length specified length of triangle will be drawn
     */
    public static void drawRightBottomTriangle(int length) {
        for (int i = 1; i <= length; i++) {
            int j = 1;
            for (; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (; j <= length; j++) {
                System.out.print(" *");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    /**
     * Draws the rhombus by specified length number
     * for example when n = 4 , it must be such as
     * drawn below :
     * <p>
     *     *
     *    * *
     *   * * *
     *  * * * *
     *   * * *
     *    * *
     *     *
     *
     * @param length specified length of rhombus will be drawn
     */
    public static void drawRhombus(int length) {
        // TODO : complete the method
    }

    /**
     * Draws the rhombus by specified length number
     * for example when n = 4 , it must be such as
     * drawn below :
     * <p>
     * * * * *
     * *     *
     * *     *
     * * * * *
     *
     * @param length specified length of rhombus will be drawn
     */
    public static void drawEmptyRectangle(int length) {
        // TODO : complete the method
    }
}
