package operatorintro;

/**
 * Created by Areg on 2/5/2017.
 */
public class OperatorDemo {
    public static void main(String[] args) {
        shiftLeft();


        byte n = -64;

        System.out.println(n < 0 ? "Negative" : "Positive");
//        printAsBinary(n);

        printAsBinary(n);
        printAsBinary(n<<26);


//        bitwise operators & | ^  >> >>>

    }

    static void printAsBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(n >> i & 1);
            if (i % 8 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static void shiftLeft(){
        byte b = -64;
        System.out.println(b << 2);

    }

    static void logicalOperator() {
        // && || ! == != > < >= <=
        boolean b1 = true;
        boolean b2 = false;
        if (b2 && b1) {//b1@ chi stugvum qani vor b2@ false e

        }
        if (b1 || b2) {//chi stugvum b2 qani vor b1 true e

        }
// xndir tiv@ tanrs hertakanutyamb grelu
    }


}


