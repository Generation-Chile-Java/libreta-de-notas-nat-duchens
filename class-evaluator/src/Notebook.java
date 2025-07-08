import java.util.*;

public class Notebook {

    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);

        Map<String, ArrayList<Integer>> gradeBook = new HashMap<>();

        System.out.println("Notebook: Student grades should only be 0 to 7");
        System.out.println("------------------------------");
        System.out.print("Enter the total number of students: ");
        int studentCount = Integer.parseInt(keyBoard.nextLine());

        System.out.print("Enter the total number of grades per student: ");
        int gradeCount = Integer.parseInt(keyBoard.nextLine());

        // To restrict quantities
        if (studentCount <= 0 || gradeCount <= 0) {
            System.out.println("Error: students and grades count can't be negative.");
            return;
        }

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
                    if (grade >= 0 && grade <= 7) { //Avoid negatives and establish a range.
                        System.out.println("Valid grade!");
                        grades.add(grade);
                        break; //Necessary exit, I had created an infinite loop
                    } else {
                        System.out.println("Invalid grade!, please enter a valid grade between 0 to 7.");
                    }
                }
            }

            gradeBook.put(studentName, grades);
        }

        //To see the saved grades and students names
        System.out.println("------------------------------");
        System.out.println("Student Notebook:");
        for (String key : gradeBook.keySet()) {
            System.out.println("Student Name: " + key + ", Grades: " + gradeBook.get(key));
        }
        System.out.println("------------------------------");
        //Displays a menu with the following options:
        //1. Display the Grade Point Average per Student.
        //2. Display whether the Grade is Pass or Fail per Student.
        //3. Display whether the Grade is Above or Below the Course Average per Student.
        //0. Exit the Menu.

        //Options Menu:
        int optionMenu;
        do {
            System.out.println("Menu:\n" +
                    "1. Show the Grade Point Average per Student\n" +
                    "2. Show whether the Grade is Pass or Fail\n" +
                    "3. Compare a Grade is Above or Bellow the Course\n" +
                    "0. Exit");
            System.out.print("Choose an Option from 0 to 3: ");

            optionMenu = Integer.parseInt(keyBoard.nextLine());

            switch (optionMenu) {
                case 1: //Avg, max and min grades per student
                    System.out.println("------------------------------");
                    for (String name: gradeBook.keySet()){
                        ArrayList<Integer> grades = gradeBook.get(name);
                        double avg = studentAverage(grades);
                        int max = Collections.max(grades);
                        int min = Collections.min(grades);
                        System.out.println(name + " Average grade: " + avg +
                                ", Max: " + max + ", Min: " + min);
                    }
                    System.out.println("------------------------------");
                    break;

                case 2: //Check by student name if pass or fails
                    System.out.println("------------------------------");
                    System.out.print("Enter a grade to check if it's passing: ");
                    int gradeCheck = Integer.parseInt(keyBoard.nextLine());
                    if (gradeCheck >= 4){
                        System.out.println("Passed!");
                    }else {
                        System.out.println("Failed!");
                    }
                    System.out.println("------------------------------");
                    break;

                case 3: //Compare avg with the course
                    System.out.println("------------------------------");
                    double courseAvg = courseAverage(gradeBook);
                    System.out.println("Course Average: " + courseAvg);
                    System.out.print("Enter the student name:  ");
                    String studentToCompare = keyBoard.nextLine();
                    System.out.print("Enter a grade to compare: ");
                    int gradeToCompare = Integer.parseInt(keyBoard.nextLine());
                    if (gradeToCompare > courseAvg) {
                        System.out.println("Above average!");
                    } else if (gradeToCompare < courseAvg) {
                        System.out.println("Below average!");
                    } else {
                        System.out.println("Average!");
                    }
                    System.out.println("------------------------------");
                    break;

                case 0: //To finish the program
                    System.out.println("------------------------------");
                    System.out.println("Bye!");
                    System.out.println("------------------------------");
                    break;

                default: //In case of an incorrect number
                    System.out.println("------------------------------");
                    System.out.println("Invalid option\n" +
                            "Try again!");
                    System.out.println("------------------------------");
            }

        }while (optionMenu != 0); //If the option result to be 0, the loop stop.

        keyBoard.close(); //To release the resources associated with a Scanner object, such as the input stream it's reading from

    }

    //Method to obtain the average grades per student
    private static double studentAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    //Method to obtain the course average
    private static double courseAverage(Map<String, ArrayList<Integer>> gradeBook) {
        int total = 0;
        int count = 0;
        for (ArrayList<Integer> grades : gradeBook.values()) {
            for (int g : grades) {
                total += g;
                count++;
            }
        }
        return (double) total / count;
    }
}