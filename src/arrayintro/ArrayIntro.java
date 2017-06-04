package arrayintro;

/**
 * Created by Areg on 2/12/2017.
 */
public class ArrayIntro {

    public static void main(String[] args) {
        //How to declare  (type [] varName or type varName []  )
//        int[] grades = null;
//        int[] grades2 = null;
          int[] averages = null ;
//        print(grades);
//        averages = grades;   compilation error: it is not possible to assign an array to a difference type array
//        grades ={1, 4, 5};   //Compilation error  see correction in the next line
//        grades = new int[]{1, 4, 5, 35};
//        print(grades);
        int[] students;
        students = new int[12];
        for (int i = 0; i < students.length; i++) {
            students[i] = i +1;
        }
        System.out.print("students: ");
        print(students);

        System.out.println(students[1]);
        print(averages);
//        grades = new int[10];
//        print(grades);
//        grades2 = grades;
//        System.out.println(grades);
//        System.out.println(grades2);


    }

    static void print(int[] a) {
        if (a == null) {
            System.out.println(a);
        } else {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
