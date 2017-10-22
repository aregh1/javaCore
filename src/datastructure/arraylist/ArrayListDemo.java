package datastructure.arraylist;

import datastructure.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Areg on 10/21/2017.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Student> arraylist = new ArrayList<Student>();
        arraylist.add(new Student("Narek","Hakobyan", 84));
        arraylist.add(new Student("Vram","Hakobyan", 87));
        arraylist.add(new Student("Areg","Hakobyan", 80));
        arraylist.add(new Student("Samvel","Hakobyan", 90));
        Student Areg = new Student("Areg","Hakobyan", 80);
        System.out.println(arraylist.contains(Areg));
    }

}

