import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.print("Enter subject do you have:");
        int NumberOfSubject = input.nextInt();

        int SubjectMarks[] = new int[NumberOfSubject];

        double total = 0;

        for (int i = 0; i < NumberOfSubject; i++) {
            System.out.print("Enter the marks in Subject (out of 100) " + (i + 1) + " : ");
            SubjectMarks[i] = input.nextInt();

            if (SubjectMarks[i] < 0 && SubjectMarks[i] > 100) {
                System.out.println("You entered wrong marks : ");
            }
            total += SubjectMarks[i];
        }
        System.out.println("\n");

        // Display total marks
        System.out.println("Your Total marks:" + total);

        // Display Percentage of total marks
        double AveragePercentage = (total / NumberOfSubject);
        System.out.println("Your Percentage is :" + AveragePercentage + "%");

        // Calculate grade
        char Grade;

        if (AveragePercentage >= 90) {
            Grade = 'A';
        } else if (AveragePercentage >= 80) {
            Grade = 'B';
        } else if (AveragePercentage >= 70) {
            Grade = 'C';
        } else if (AveragePercentage >= 60) {
            Grade = 'D';
        } else if (AveragePercentage >= 50) {
            Grade = 'E';
        } else {
            Grade = 'F';
        }
        // Display the grade
        System.out.println("Your grade is :" + Grade);

        input.close();
    }
}