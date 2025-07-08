import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Notebook {

    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);

        Map<String, ArrayList<Integer>> gradeBook = new HashMap<>();

        System.out.println("Notebook: Student grades should only be 0 to 7");
        System.out.println("------------------------------\n");

        System.out.print("Enter the total number of students: ");
        int studentCount = Integer.parseInt(keyBoard.nextLine());

        System.out.print("Enter the total number of grades per student: ");
        int gradeCount = Integer.parseInt(keyBoard.nextLine());

        //To input students names and grades

        for (int s = 0; s < studentCount; s++) {
            System.out.print("Enter student name: ");
            String studentName = keyBoard.nextLine();
            ArrayList<Integer> grades = new ArrayList<>();

            for (int g = 1; g <= gradeCount; g++) {
                int grade;
                while (true) {
                    System.out.print("Enter grade #" + g + ": ");
                    grade = Integer.parseInt(keyBoard.nextLine());
                    if (grade >= 0 && grade <= 7) {
                        System.out.println("Valid grade!\n");
                        grades.add(grade);
                        break; //Necessary exit, I had created an infinite loop
                    } else {
                        System.out.println("Invalid grade!, please enter a valid grade between 0 to 7.\n");
                    }
                }
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

