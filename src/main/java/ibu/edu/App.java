package ibu.edu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\Global-University-Students\\Global_University_Students.csv";

        File file = new File(path);

        Scanner input = new Scanner(file);
        Scanner reader = new Scanner(System.in);

        String[] students;
        RedBlackTree rbt = new RedBlackTree();

        int i = 0;
        while (input.hasNextLine() && i < 1000000) {

            String data = input.nextLine();
            students = data.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            int studentID = Integer.parseInt(students[0]);
            int studentYearOfEnrolment = Integer.parseInt(students[6]);
            Student student = new Student(studentID, students[1], students[2], students[3], students[4], students[5], studentYearOfEnrolment);
            rbt.put(studentID, student);
            i++;

        }
        input.close();

        System.out.println("Enter the ID of the student you want to look up: ");
        int lookUpID = reader.nextInt();
        Student lookUpStudent =(Student) rbt.get(lookUpID);
        if(lookUpStudent!= null) {
            System.out.println("Student ID: " + lookUpStudent.getStudentID());
            System.out.println("Name and surname: " + lookUpStudent.getStudentName());
            System.out.println("Date of birth: " + lookUpStudent.getStudentDateOfBirth());
            System.out.println("University: " + lookUpStudent.getUniversityName());
            System.out.println("Department code: " + lookUpStudent.getDepartmentCode());
            System.out.println("Department: " + lookUpStudent.getDepartmentName());
            System.out.println("Year of enrolment: " + lookUpStudent.getStudentYearOfEnrolment() + "\n");
            System.out.println("The student was retrieved from rbt in " + rbt.getSteps() + " steps.");
        } else{
            System.out.println("The student with the given ID does not exist.\n");
            System.out.println("The search was completed in " + rbt.getSteps() + " steps.");
        }
        System.out.println("Total number of red links in a tree : " + rbt.countRedLinks());
    }
}
