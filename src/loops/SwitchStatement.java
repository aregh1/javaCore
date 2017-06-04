package loops;

public class SwitchStatement {

    public static void main(String[] args) {
//        printGrade(21);
        printGrade(9);

    }

    private static void printGrade(int grade) {
        switch (grade) {
            case 10:
            case 9:
                System.out.println("Excellent");
                break;
            case 8:
            case 7:
                System.out.println("Good");
                break;
            case 6:
            case 5:
                System.out.println("Fair");
                break;
            case 4:
            case 3:
            case 2:
            case 1:
                System.out.println("Bad");
                break;
            default:
                System.err.print("Incorrect grade:" + grade);

        }
    }
}
