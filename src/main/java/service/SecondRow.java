package service;

import pojo.Cell;
import pojo.Ticket;

import java.util.ArrayList;
import java.util.List;

public class SecondRow implements WinningScenarios {

    @Override
    public boolean checkIfWon(Ticket ticket) {
        boolean retFlag = false;
        List<String> winningNumbs = getAllAnnouncedNumbers(ticket);
        if (winningNumbs.size() == ticket.getCell()[1].length) {
            printWinningNumbers(winningNumbs, "Second Row");
            retFlag = true;
        }
        return retFlag;
    }

    private List<String> getAllAnnouncedNumbers(Ticket ticket) {
        List<String> winningNumbs = new ArrayList<>();
        for (int col = 0; col < ticket.getCell()[1].length; col++) {
            Cell cell = ticket.getCell()[1][col];

            if (cell.isAnnounced())
                winningNumbs.add(cell.getVal().replace("!", ""));
        }
        return winningNumbs;
    }


}
