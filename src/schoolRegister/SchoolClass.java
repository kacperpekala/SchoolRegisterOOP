package schoolRegister;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private char letter; //zrobiłbym stringa i nazwał classId, bo klasa w szkole nie musi się ograniczać jedynie do jednej litery
    private int degree; //raczej chodzi o year albo amerykański grade 
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
        int i = 1; // zmienna "i" nic mi nie mówi w tym przypadku, lepsze byłoby np rowNumber albo samo row
        for (Student student : students){
            System.out.println(i + ": " + student.getName() + " " + student.getSurname() + " grade: " + student.getGrade());
            i++;
            // mozliwe, ze cos takiego by dzialalo spoko 
            // System.out.println((i++) + ": " + student.getName() + " " + student.getSurname() + " grade: " + student.getGrade());
            // https://stackoverflow.com/questions/24853/what-is-the-difference-between-i-and-i
        }
        
    }

}
