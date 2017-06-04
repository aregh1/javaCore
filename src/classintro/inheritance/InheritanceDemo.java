package classintro.inheritance;

/**
 * Created by Areg on 4/1/2017.
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        A aO = new B(1);
        aO.show();
        I i = new AA();
        AA aa = new AA();
//        aO = (A)aa;   //Compile error
        C c = (C)i;
        i = c;
        if(Math.abs(-1)==1) {
            i = aO;
        }
        if(i.getClass().getSimpleName().equals("A")){
            System.out.println("i is a A");
        }
        if(i.getClass().getSimpleName().equals("B")){
            System.out.println("i is a B");
        }

        if(i instanceof A){
            ((B)i).show();
        }
    }
}


 interface I {
   abstract void print();

}

class AA implements I{
    @Override
    public void print() {

    }
}
class A implements I{
    private int a = 22;
    private static int aStat = 1;
    private final static int aStatFinal;

    {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hey Instance  folk");
        }
    }
    private int aaa = -2;
    static {
        aStatFinal = 2;
        for (int i = 0; i < 5; i++) {
            System.out.println("Hey Static folk");
        }
    }


    public A(int a) {
        show();
        this.a = a;
    }

    void show(){
        System.out.println("In A: show a = " + a);
    }

    @Override
    public void print() {
        System.out.println("In Printer Of A: ");
    }
}

class B extends A {
    private int a = 10;

    public B(int a) {
        super(100);
        this.a = a;
    }

    void show(){
        System.out.println("In B: show a = " + a);
        super.show();
    }
}

class C extends B {
    private int a = 10;

    public C(int a) {
        super(100);
        this.a = a;
    }

    void show(){
        System.out.println("In B: show a = " + a);
        super.show();
    }
}
