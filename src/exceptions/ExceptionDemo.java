package exceptions;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

//@SuppressWarnings("all")
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            if(true){
                return;
            }
            throwException(2);
            System.out.println("hdvvhwhj");

        } catch (Exception e) {
            e.printStackTrace();

        }  finally {
            System.out.println("ZZZZZZZZZZZZZZZZZZZZZ");
        }
    }

    //    @SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
    static void throwException(int a) throws Exception {
        switch (a) {
            case 0:
                throw new RuntimeException();
            case 1:
                throw new Exception();
            case 2:
                throw new NoSuchFileException("SOmeFile");
            default:
                throw new IOException();
        }

    }
}


class A {
    A()throws Exception{

    }

    void meth()throws Exception{

    }
}
class B extends A {

    B () throws Throwable{}
    @Override
    void meth()throws Exception{

    }
}
