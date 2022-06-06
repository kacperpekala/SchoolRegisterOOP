package schoolRegister;

import java.util.ArrayList;
import java.util.List;

public class SchoolRegister{

    private List<SchoolClass> schoolClasses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void saveClass(SchoolClass schoolClass){
        schoolClasses.add(schoolClass);
    }

    public void saveTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void displayClasses(){
        System.out.println("classes at school");
        int i = 1;
        for (SchoolClass schoolClass : schoolClasses){
            System.out.println(i + ": " + schoolClass.getDegree() + schoolClass.getLetter() + " " + schoolClass.getClassTutor().getName() + schoolClass.getClassTutor().getSurname());
            i++;
        }
    }

    public void displayTeachers(){
        System.out.println("All teachers at school");
        int i = 1;
        for (Teacher teacher : teachers){
            System.out.println(i + ": " + teacher.getName() + " " + teacher.getSurname());
            i++;
        }
    }

    public List<Teacher> avilableTeachers(){
        List<Teacher> availableTeachers =  new ArrayList<>();
        for (Teacher teacher : teachers){
            if (teacher.isTutor() == false){
                availableTeachers.add(teacher);
            }
        }
        return availableTeachers;
    }

    public SchoolClass selectClass(int userInput){
        userInput -= 1;
        return schoolClasses.get(userInput);
    }
}
