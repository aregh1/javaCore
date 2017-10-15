package datastructure.set;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {
        //Hashing algorithm
        Set<String> set = new HashSet<>();
        set.add("first");
        set.add("second");
        set.add("third");
        set.add("forth");
        Iterator<String> it = set.iterator();
        for (; it.hasNext();) {
            System.out.println(it.next());
        }


        System.out.println("----------------------------------------");
        //SortedSets, TreeSet
        set = new TreeSet<>();
        set.add("first");
        set.add("second");
        set.add("third");
        set.add("forth");
        it = set.iterator();
        for (; it.hasNext();) {
            System.out.println(it.next());
        }

    }
}
