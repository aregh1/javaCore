package classintro;

/**
 * Created by Areg on 2/26/2017.
 */
public class RectangleTest {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 5);
        Rectangle r2 = new Rectangle();
        Rectangle r = new Rectangle(4, 6);

        System.out.println("before " + r1.getWidth());
        r1.setWidth(-100);
        System.out.println("after " + r1);

        System.out.println(r1.getPerimeter());
        System.out.println(r.getPerimeter());
        System.out.println(r2.getPerimeter());

    }
}
