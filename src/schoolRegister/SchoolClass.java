package schoolRegister;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private char letter;
    private int degree;
    private Teacher classTutor;
    private List<Student> students = new ArrayList<>();

    public SchoolClass(int degree, char letter, Teacher classTutor){
       this.degree = degree;
       this.letter = letter;
       this.classTutor = classTutor;
       classTutor.setAsTutor();
    }

    public char getLetter() {
        return letter;
    }

    public int getDegree() {
        return degree;
    }

    public Teacher getClassTutor(){
        return classTutor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void displayStudents(){
        int i = 1;
        for (Student student : students){
            System.out.println(i + ": " + student.getName() + " " + student.getSurname() + " grade: " + student.getGrade());
            i++;
        }
    }

}
