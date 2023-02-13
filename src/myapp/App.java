package myapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        String[] choices = {"Scissors", "Paper", "Stone"};

        // track number of times player wins and number of times computer wins
        int playerWinCount = 0;
        int computerWinCount = 0;

        // keyboard input into Scanner object
        Scanner scanner = new Scanner(System.in);

        // instantiate a SCP object
        SCP scp = new SCP();

        // variables to keep track of player's selection
        String playerSelection = "";

        while (!playerSelection.equalsIgnoreCase("Q")) {
            // game logic here

            String winner = "";
            int computerSelection = scp.generateComputerChoice();

            System.out.println("Enter (0) to play scissors, (1) to play paper, (2) to play stone, or (Q) to quit: ");
            playerSelection = scanner.nextLine();

            if (!playerSelection.equalsIgnoreCase("Q")) {
                Integer playerOption = Integer.parseInt(playerSelection);

                // valid player entry
                if (playerOption >= 0 && playerOption <=2) {
                    winner = scp.checkWinner(playerOption, computerSelection);
                    if (winner.equalsIgnoreCase("Human")) {
                        playerWinCount++;
                        System.out.println("Player wins this round.");
                    } else if (winner.equalsIgnoreCase("Computer")) {
                        computerWinCount++;
                        System.out.println("Computer wins this round.");
                    } else {
                        System.out.println("Tied this round.");
                    }

                } else {
                    System.out.println("You have entered an invalid option.");
                    continue;
                }
            }
        }

        System.out.printf("Player win count: %d\n", playerWinCount);
        System.out.printf("Computer win count: %d\n", computerWinCount);
        System.out.println(playerWinCount>computerWinCount ? "Player wins!" : (playerWinCount<computerWinCount ? "Computer wins!" : "Tie!"));

        // ServerSocket server = new ServerSocket(3000);
    }
}