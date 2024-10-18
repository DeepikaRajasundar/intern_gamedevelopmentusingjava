package gameApp;

import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rps = {"rock", "paper", "scissors"};
        String computerMove = rps[(int)(Math.random() * 3)];

        System.out.println("Enter your move (rock, paper, or scissors): ");
        String userMove = scanner.nextLine().toLowerCase();

        if (userMove.equals(computerMove)) {
            System.out.println("It's a tie!");
        } else if (userMove.equals("rock") && computerMove.equals("scissors") ||
                   userMove.equals("paper") && computerMove.equals("rock") ||
                   userMove.equals("scissors") && computerMove.equals("paper")) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose! Computer chose " + computerMove);
        }
        
        scanner.close();
    }
}
