package datastructure.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {



    public static void main(String[] args) {

        Set<Student> students = new TreeSet<>(new StudentComparator());
        students.add(new Student("Areg", "Hakobyan", 99));
        students.add(new Student("Narek", "Hakobyan", 100));
        students.add(new Student("Karen", "Vardanyan", 30));
        students.add(new Student("Kuku", "Kukich", 50));

        for (Student student : students) {
            System.out.println(student);
        }


    }

    private static class StudentComparator implements Comparator<Student> {


        @Override
        public int compare(Student s1, Student s2) {
            if(!s1.getName().equals(s2.getName())){
                return s1.getName().compareTo(s2.getName());
            }

            if(!s1.getSurname().equals(s2.getSurname())){
                return s1.getName().compareTo(s2.getSurname());
            }
//            else if(s1.getAverageGrade() != (s2.getAverageGrade())) {
                return Integer.compare(s1.getAverageGrade(), s2.getAverageGrade());
//            }

        }
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
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}