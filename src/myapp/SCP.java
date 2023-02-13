package myapp;

import java.net.ServerSocket;
import java.util.Random;

public class SCP {
    // SCP is acronym for Scissors Paper Stone

    public int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3);
    }
    
    public String checkWinner(int playerChoice, int computerChoice) {
    
        // 0 : scissors
        // 1 : paper
        // 2 : stone
        
        int difference = playerChoice - computerChoice;

        if (difference == 0) {
            return "Tie";
        } else if (difference == -1 || difference == 2) {
            return "Human";
        } else {
            return "Computer";
        }
    }
    
}
