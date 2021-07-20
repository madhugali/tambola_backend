package service;

import pojo.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public interface WinningScenarios {

    boolean checkIfWon(Ticket ticket);

    default void printWinningNumbers(List<Integer> winningNumbs, String resultsType) {
        System.out.println("----------- " + resultsType + " Winner Results!! >> " + winningNumbs.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

}
