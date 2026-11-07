
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAttendance {

    static ArrayList<String> students = new ArrayList<>();
    static ArrayList<String> attendance = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT ATTENDANCE SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    students.add(name);
                    attendance.add("Not Marked");
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i));
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students available!");
                        break;
                    }

                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i));
                    }

                    System.out.print("Enter student number: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    if (number >= 1 && number <= students.size()) {
                        System.out.print("Enter P for Present or A for Absent: ");
                        String status = sc.nextLine();

                        if (status.equalsIgnoreCase("P")) {
                            attendance.set(number - 1, "Present");
                        } else if (status.equalsIgnoreCase("A")) {
                            attendance.set(number - 1, "Absent");
                        } else {
                            System.out.println("Invalid status!");
                            break;
                        }

                        System.out.println("Attendance marked!");
                    } else {
                        System.out.println("Invalid student number!");
                    }
                    break;

                case 4:
                    System.out.println("\n===== ATTENDANCE RECORD =====");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i) + " - " + attendance.get(i));
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
