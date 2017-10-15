package datastructure.impllist;


import java.util.List;

/**
 * A program that demonstrates the LinkedList class
 */
public class ListTest {
    public static void main(String[] args) {

        List<String> l = new java.util.LinkedList<>();
        l.add("First");

        java.util.ListIterator<String> it = (java.util.ListIterator<String>) l.iterator();
        if (it.hasNext()) {
            it.add("Second");
            it.add("third");
            it.add("forth");
        }

        it = (java.util.ListIterator<String>) l.iterator();
        for (; it.hasNext(); ) {
            System.out.println(it.next());
        }

//        LinkedList<String> list = new LinkedListImpl<>();
//        list.addFirst("First");
////        list.addFirst("Second");
////        list.addFirst("third");
////        list.addFirst("forth");
//
//        ListIterator iterator = list.listIterator();
//        if (iterator.hasNext()) {
////            iterator.next();
//
//            iterator.add("Second");
//            iterator.add("third");
//            iterator.add("forth");
//
//
//            for (iterator = list.listIterator(); iterator.hasNext(); ) {
//                System.out.println(iterator.next());
//            }
//        }


    }
}
