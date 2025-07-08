import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Notebook {

    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);

        Map<String, ArrayList<Integer>> gradeBook = new HashMap<>();

        System.out.println("Enter the total number of students: ");
        int studentCount = Integer.parseInt(keyBoard.nextLine());

        System.out.println("Enter the total number of grades per student: ");
        int gradeCount = Integer.parseInt(keyBoard.nextLine());

        //To input students names and grades

        for (int s = 0; s < studentCount; s++) {
            System.out.println("Enter student name: ");
            String studentName = keyBoard.nextLine();
            ArrayList<Integer> grades = new ArrayList<>();

            for (int g = 1; g <= gradeCount; g++) {
                System.out.print("Enter grade #" + g + ": ");
                int grade = Integer.parseInt(keyBoard.nextLine());
                grades.add(grade);
            }

            gradeBook.put(studentName, grades);
        }

        System.out.println("\nStudent Notebook:");
        for (String key : gradeBook.keySet()) {
            System.out.println("Student Name: " + key + ", Grades: " + gradeBook.get(key));
        }

        keyBoard.close(); //To release the resources associated with a Scanner object, such as the input stream it's reading from
    }

    //Options Menu:
//Displays a menu with the following options:
//1. Display the Grade Point Average per Student.
//2. Display whether the Grade is Pass or Fail per Student.
//3. Display whether the Grade is Above or Below the Course Average per Student.
//0. Exit the Menu.



}

