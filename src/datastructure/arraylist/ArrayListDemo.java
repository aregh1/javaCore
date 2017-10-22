package datastructure.arraylist;

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

class Student {
    private String Name;
    private String Surname;
    private int averageGrade;

    public Student(String name, String surname, int averageGrade) {
        Name = name;
        Surname = surname;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public  boolean equals(Object object){
        if(object instanceof Student) {
            Student student = (Student) object;
            return this.getName().equals(student.getName()) && this.getSurname().equals(student.getSurname()) && this.getAverageGrade() == student.getAverageGrade();
        }
        return false;
    }


    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
