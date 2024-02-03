import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 10;
        int totalAttempts = 0;
        int score = 0;

        boolean playAgain = true;
        
        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("Enter the number between 1 to 100: ");
            System.out.println("You have only max attempts : " + maxAttempts);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts = attempts;
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");

            if (playAgain) {
                System.out.println("Let's play again!");
            } else {
                System.out.println("Following is your score:");
                System.out.println("Attempt :" + totalAttempts + "\nRounds won :" + score);
            }
        }

        scanner.close();
    }
}
