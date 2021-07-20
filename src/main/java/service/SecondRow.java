package service;

import pojo.Cell;
import pojo.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondRow implements WinningScenarios {

    private boolean isProcessed = false;

    @Override
    public boolean checkIfWon(Ticket ticket) {
        if (isProcessed) return true;

        boolean retFlag = false;
        List<Integer> winningNumbs = getAllAnnouncedNumbers(ticket);
        List<Integer> allNonZeroElements = getAllNonZeroElements(ticket);

        if (winningNumbs.equals(allNonZeroElements)) {
            printWinningNumbers(winningNumbs, "Second Row");
            retFlag = true;
            isProcessed = true;
        }
        return retFlag;
    }

    private List<Integer> getAllNonZeroElements(Ticket ticket) {
        return IntStream
                .range(0, ticket.getCell()[1].length)
                .mapToObj(e1 -> ticket.getCell()[1][e1])
                .filter(e2 -> e2.getVal() != 0)
                .map(Cell::getVal)
                .collect(Collectors.toList());
    }

    private List<Integer> getAllAnnouncedNumbers(Ticket ticket) {
        List<Integer> winningNumbs = new ArrayList<>();
        for (int col = 0; col < ticket.getCell()[1].length; col++) {
            Cell cell = ticket.getCell()[1][col];

            if (cell.isAnnounced())
                winningNumbs.add(cell.getVal());
        }
        return winningNumbs;
    }


}
