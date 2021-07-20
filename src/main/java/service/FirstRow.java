package service;

import pojo.Cell;
import pojo.Ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstRow implements WinningScenarios {

    private boolean isProcessed = false;

    @Override
    public boolean checkIfWon(Ticket ticket) {

        if (isProcessed) return true;

        boolean retFlag = false;
        List<Integer> winningNumbs = getAllAnnouncedNumbers(ticket);
        List<Integer> allNonZeroElements = getAllNonZeroElements(ticket);
        if (winningNumbs.equals(allNonZeroElements)) {
            printWinningNumbers(winningNumbs, "First Row");
            retFlag = true;
            isProcessed = true;
        }
        return retFlag;
    }

    private List<Integer> getAllNonZeroElements(Ticket ticket) {
        return IntStream
                .range(0, ticket.getCell()[0].length)
                .mapToObj(e1 -> ticket.getCell()[0][e1])
                .filter(e2 -> e2.getVal() != 0)
                .map(Cell::getVal)
                .collect(Collectors.toList());
    }

    private List<Integer> getAllAnnouncedNumbers(Ticket ticket) {
        return IntStream.range(0, ticket.getCell()[0].length)
                .mapToObj(e1 -> ticket.getCell()[0][e1])
                .filter(Cell::isAnnounced)
                .map(Cell::getVal)
                .collect(Collectors.toList());
    }

}
