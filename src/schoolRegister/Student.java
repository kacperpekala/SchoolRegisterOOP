package schoolRegister;

public class Student {
    private String name;
    private String surname;
    private Integer grade;

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }
}
