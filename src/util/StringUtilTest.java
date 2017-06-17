package util;

/**
 * Created by Areg on 5/27/2017.
 */
public class StringUtilTest {
    public static void main(String[] args) {
//        System.out.println(StringUtil.toLowerCase("AgyyugyuL"));
//        System.out.println(StringUtil.changeCase("AgyyugyuL",0,9));
        print(StringUtil.split("one=two=three=four====",'='));
//        System.out.println(StringUtil.subString("sjfhewfwbhscsccscsasc", 1, 4));
//        System.out.println(StringUtil.trim("     fffeweefwefw fe wfeffewfw        s"));
    }

    static <T> void print(T[] array){
        for (T t : array) {
            System.out.println(t);
        }

    }
}
