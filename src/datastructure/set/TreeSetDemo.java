package datastructure.set;

import datastructure.Student;

import java.security.InvalidParameterException;
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
        private StudentComparatorMode studentComparatormode;

        public StudentComparator() {
            studentComparatormode = StudentComparatorMode.BYNAME;
        }

        public StudentComparator(StudentComparatorMode studentComparatormode) {
            this.studentComparatormode = studentComparatormode;
        }

        @Override
        public int compare(Student s1, Student s2) {
//            if (!s1.getName().equals(s2.getName())) {
//                return s1.getName().compareTo(s2.getName());
//            }
//
//            if (!s1.getSurname().equals(s2.getSurname())) {
//                return s1.getName().compareTo(s2.getSurname());
//            }
////            else if(s1.getAverageGrade() != (s2.getAverageGrade())) {
//            return Integer.compare(s1.getAverageGrade(), s2.getAverageGrade());
////            }
            return compareByMode(s1, s2);
        }

        private int compareByMode(Student s1, Student s2) {
            switch (studentComparatormode) {
                case BYAVERAGEGRADE:
                    return Integer.compare(s1.getAverageGrade(), s2.getAverageGrade());
                case BYNAME:
                    return s1.getName().compareTo(s2.getName());
                case BYSURNAME:
                    return s1.getName().compareTo(s2.getSurname());
                default:
                    throw new InvalidParameterException();// todo: Add relevant message
            }
        }

        static enum StudentComparatorMode {
            BYNAME,
            BYSURNAME,
            BYAVERAGEGRADE,;
        }
    }
}

