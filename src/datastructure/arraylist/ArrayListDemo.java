package datastructure.arraylist;

import datastructure.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Areg on 10/21/2017.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Narek", "Hakobyan", 84));
        list.add(new Student("Vram", "Hakobyan", 87));
        list.add(new Student("Areg", "Hakobyan", 80));
        list.add(new Student("Samvel", "Hakobyan", 90));
        Student areg = new Student("Areg", "Hakobyan", 80);

//        for (ListIterator<Student> it = list.listIterator(); it.hasNext(); ) {
//            it.add(new Student("nm", "snm", 11));
//            System.out.println(it.next());
//            System.out.println(list.contains(areg));
//        }

        for (int i = 0; i < list.size(); i++) {
//            list.add(new Student("nm", "snm", 11));
            System.out.println(list.get(i));
        }
    }


}

