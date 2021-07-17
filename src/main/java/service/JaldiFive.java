package service;

import contants.TambolaConstants;
import pojo.Cell;
import pojo.Ticket;

import java.util.ArrayList;
import java.util.List;

public class JaldiFive implements WinningScenarios {

    @Override
    public boolean checkIfWon(Ticket ticket) {
        boolean retFlag = false;
        List<String> winningNumbs = getAllAnnouncedNumbers(ticket);
        if (winningNumbs.size() == TambolaConstants.JALDI_FIVE_VALUE) {
            printWinningNumbers(winningNumbs, "Jaldi Five");
            retFlag = true;
        }
        return retFlag;
    }

    public List<String> getAllAnnouncedNumbers(Ticket ticket) {
        List<String> winningNumbs = new ArrayList<>();
        for (int row = 0; row < ticket.getCell().length; row++) {
            for (int col = 0; col < ticket.getCell()[1].length; col++) {
                Cell cell = ticket.getCell()[row][col];

                if (cell.isAnnounced()) {
                    winningNumbs.add(cell.getVal().replace("!", ""));

                    if (winningNumbs.size() == TambolaConstants.JALDI_FIVE_VALUE) {
                        return winningNumbs;
                    }
                }
            }
        }
        return winningNumbs;
    }

}
