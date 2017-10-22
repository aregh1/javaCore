package datastructure;

public class Student {
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

//    @Override
//    public  boolean equals(Object object) {
//        if(object instanceof Student) {
//            Student student = (Student) object;
//            return this.getName().equals(student.getName()) && this.getSurname().equals(student.getSurname()) && this.getAverageGrade() == student.getAverageGrade();
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (averageGrade != student.averageGrade) return false;
        if (!Name.equals(student.Name)) return false;
        return Surname.equals(student.Surname);
    }

    @Override
    public int hashCode() {
        int result = Name.hashCode();
        result = 31 * result + Surname.hashCode();
        result = 31 * result + averageGrade;
        return result;
    }
}