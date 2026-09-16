import java.util.*;

public class numbergame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<Integer> roundScores = new ArrayList<>();
        ArrayList<Integer> roundAttempts = new ArrayList<>();
        ArrayList<String> roundStatus = new ArrayList<>();

        String decision;
        int round = 1;
        int totalScore = 0;

        do {

            int secret_num = rand.nextInt(100) + 1;
            int attempts = 0;
            int guess_num = 0;
            int score = 0;
            String status = "lose";

            System.out.println("\n-----ROUND " + round + " -----");

            while ((guess_num != secret_num) && (attempts < 3)) {

                try {

                    System.out.print("Guess a number between 1 and 100: ");
                    guess_num = sc.nextInt();

                    if (guess_num == secret_num) {

                        System.out.println(
                                "Congratulations! You guessed it! The secret number is "
                                        + secret_num);

                        status = "winner";

                        if (attempts == 0) {
                            score = 100;
                        } else if (attempts == 1) {
                            score = 70;
                        } else {
                            score = 50;
                        }

                    } else if (guess_num > secret_num) {

                        System.out.println("Oh! The number you entered is too high.");

                    } else {

                        System.out.println("Oh! The number you entered is too low.");
                    }

                    attempts++;

                } catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input! Please enter a number.");

                    sc.nextLine();
                }
            }

            if (guess_num != secret_num) {

                System.out.println("Sorry, you lost!");
                System.out.println("The secret number was: " + secret_num);

                score = 0;
                status = "lose";
            }

            //saving current round record
            roundScores.add(score);
            roundAttempts.add(attempts);
            roundStatus.add(status);

            totalScore = totalScore + score;

            // Current round result
            System.out.println("\n---- ROUND " + round + " RESULT ----");
            System.out.println("Attempts: " + attempts);
            System.out.println("Secret number: " + secret_num);
            System.out.println("Status: " + status);
            System.out.println("Score: " + score);

            sc.nextLine();

            System.out.print("\nDo you want to play again? yes/no: ");
            decision = sc.nextLine();

            round++;

        } while (decision.equalsIgnoreCase("yes"));

        // Final summary
        System.out.println("\n==============================");
        System.out.println("       GAME SUMMARY");
        System.out.println("==============================");

        for (int i = 0; i < roundScores.size(); i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.println("Attempts: " + roundAttempts.get(i));
            System.out.println("Status: " + roundStatus.get(i));
            System.out.println("Score: " + roundScores.get(i));
        }

        System.out.println("\n------------------------------");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Rounds Played: " + roundScores.size());
        System.out.println("------------------------------");

        System.out.println("\nThanks for playing!");

        sc.close();
    }
}