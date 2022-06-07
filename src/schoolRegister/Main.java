package schoolRegister;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean runApp = true;

        SchoolRegister schoolRegister = new SchoolRegister();

        do{
            System.out.println("SCHOOL REGISTER");
            System.out.println("---------------");
            System.out.println("1. Add teachers");
            System.out.println("2. Display all teachers ");
            System.out.println("3. Create Class");
            System.out.println("4. Display Classes");
            System.out.println("5. Add Students");
            System.out.println("6. Display students");
            System.out.println("7. Give grades");
            System.out.println("8. Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    boolean addAnotherTeacher = true;
                    do {
                        System.out.println("Add a new teacher");
                        System.out.println("Enter a Teacher's name");
                        scan.nextLine();
                        String name = scan.nextLine();
                        System.out.println("Enter a Teacher's surname");
                        String surname = scan.nextLine();
                        Teacher newTeacher = new Teacher(name, surname);
                        schoolRegister.saveTeacher(newTeacher);
                        System.out.println("Do you want add another teacher? (Y/n)");
                        String userInput = scan.next();
                        if (userInput.equals("n")) { 
                            addAnotherTeacher = false;
                        }
                        /*
                        System.out.println("Do you want add another teacher? (Y/n)");
                        String userInput = scan.next();
                        if (userInput.equals("n")) { 
                            addAnotherTeacher = false;
                        }
                        czesto powtarza Ci sie tutaj ten kawalek kodu, mozesz zrobic odzielna metode, ktora bedzie przyjmowala stringa i booleana
                        a nastepnie sobie dzialala
                        ogolnie "n" wjebalbym do zmiennej, bo powiedzmy ze w przyszlosci chcialbys to zmienic na cancel 
                        to nie bedziesz napierdalal podmieniania, tylko zmienisz wartosc zmiennej
                        No i co by sie stalo jakbym wpisal w inputa "chujNieChce"
                        To wydaje mi sie ze nadal kazaloby dodac kolejnego teachera
                        
                        */
                    } while (addAnotherTeacher);
                    break;
                case 2:
                    if (!schoolRegister.getTeachers().isEmpty()) {
                        System.out.println("All teachers at school");
                        schoolRegister.displayTeachers();
                    } else {
                        System.out.println("There are no teachers at school"); // spoko, ze obslugujesz wyjatki 
                    }
                    break;
                case 3:
                    boolean addNextClass = true;
                    do {
                        List<Teacher> availableTeachers = schoolRegister.avilableTeachers();
                        if (availableTeachers.isEmpty()) {
                            System.out.println("The are no available teachers.If you want create a new class you have hire new people");
                            break;
                        } else {
                            String userInput;
                            System.out.println("Enter a degree");
                            int degree = scan.nextInt();
                            System.out.println("Enter a letter");
                            char letter = scan.next().charAt(0);

                            System.out.println("Set a class's tutor");
                            int i = 1;
                            for (Teacher availableTeacher : availableTeachers) {
                                System.out.println(i + ": " + availableTeacher.getName() + " " + availableTeacher.getSurname());
                                i++;
                            }
                            Teacher selectedTeacher = availableTeachers.get(scan.nextInt() - 1);


                            SchoolClass schoolClass = new SchoolClass(degree, letter, selectedTeacher);
                            schoolRegister.saveClass(schoolClass);
                            System.out.println("Do you want add another class?(Y/n)");
                            scan.nextLine();
                            userInput = scan.nextLine();
                            if (userInput.equals("n")) {
                                addNextClass = false;
                            }
                        }
                    } while (addNextClass);
                    break;
                case 4:
                    if (!schoolRegister.getSchoolClasses().isEmpty()) {
                        schoolRegister.displayClasses();
                    } else {
                        System.out.println("there are no classes");
                    }
                    break;
                case 5:
                    boolean addStudentToDifClass = true;
                    if (!schoolRegister.getSchoolClasses().isEmpty()) {
                        do {
                            boolean nextStudent = true;
                            System.out.println("Select in which class you want add a new students");
                            schoolRegister.displayClasses();
                            int selectClass = scan.nextInt();
                            SchoolClass selectedClass = schoolRegister.selectClass(selectClass);
                            scan.nextLine();
                            do {
                                System.out.println("Enter Student's name");
                                String name = scan.nextLine();
                                System.out.println("Enter Student's surname");
                                String surname = scan.nextLine();
                                selectedClass.addStudent(new Student(name, surname));
                                System.out.println("Do you want add another student to this class? (Y/n)");
                                String userInput = scan.nextLine();
                                if (userInput.equals("n")) {
                                    nextStudent = false;
                                }
                            } while (nextStudent);
                            System.out.println("Do you want select different class? (Y/n)");
                            String userInput = scan.nextLine();
                            if (userInput.equals("n")) {
                                addStudentToDifClass = false;
                            }
                        } while (addStudentToDifClass);
                    } else {
                        System.out.println("there are no classes ate school");
                    }
                    break;
                case 6:
                    if (!schoolRegister.getSchoolClasses().isEmpty()) {
                        boolean displayDifClass = true;
                        do {
                            System.out.println("Select which class's students you want to display");
                            schoolRegister.displayClasses();
                            int selectClass = scan.nextInt();
                            scan.nextLine();
                            SchoolClass selectedClass = schoolRegister.selectClass(selectClass);
                            selectedClass.displayStudents();
                            System.out.println("Do you want display students from other class? (Y/n)");
                            String userInput = scan.nextLine();
                            if (userInput.equals("n")) {
                                displayDifClass = false;
                            }
                        } while (displayDifClass);
                    } else {
                        System.out.println("there are no classes at school");
                    }
                    break;
                case 7:
                    boolean studentsFromNextClass = true;
                    if (!schoolRegister.getSchoolClasses().isEmpty()) {
                        do {
                            System.out.println("Select a class");
                            schoolRegister.displayClasses();
                            int userInput = scan.nextInt();
                            SchoolClass selectedClass = schoolRegister.selectClass(userInput);
                            List<Student> students = selectedClass.getStudents();
                            if (!students.isEmpty()) {
                                for (Student student : students) {
                                    if (student.getGrade() == null) {
                                        System.out.println(student.getName() + " " + student.getSurname());
                                        System.out.println("enter a note");
                                        int note = scan.nextInt(); // dodalbym validacje ze nie mozesz np wpierdolic tutaj 2137 i umieścić ja w zmiennych, a pozniej z jakas metodka cos sie bawic 
                                        student.setGrade(note);
                                    }
                                    else {
                                        System.out.println("Students have already a grade");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("There are no students in this class");
                            }
                            System.out.println("Do you want select students from diff class? (Y/n)");
                            scan.nextLine();
                            String userAnswer = scan.nextLine();
                            if (userAnswer.equals("n")){
                                studentsFromNextClass = false;
                            }
                        }while (studentsFromNextClass) ;
                    } else{
                        System.out.println("There are no classes");
                    }
                    break;
                case 8:
                    runApp = false;
                    break;
            }
        } while (runApp);
    }

}
