package schoolRegister;

public class Teacher {
    private String name;
    private String surname;
    private boolean isTutor = false;

    public Teacher(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isTutor() {
        return isTutor;
    }

    public void setAsTutor(){
        isTutor = true;
    }

}
