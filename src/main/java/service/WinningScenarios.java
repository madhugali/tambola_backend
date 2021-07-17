package service;

import pojo.Ticket;

import java.util.List;

public interface WinningScenarios {

    boolean checkIfWon(Ticket ticket);

    default void printWinningNumbers(List<String> winningNumbs, String resultsType) {
        System.out.println("----------- " + resultsType + " Winner Results!! >> " + String.join(",", winningNumbs));
    }

}
