package service;

import contants.TambolaConstants;
import pojo.Cell;
import pojo.Ticket;

import java.util.ArrayList;
import java.util.List;

public class JaldiFive implements WinningScenarios {

    private boolean isProcessed = false;

    @Override
    public boolean checkIfWon(Ticket ticket) {

        if (isProcessed) return true;

        boolean retFlag = false;
        List<Integer> winningNumbs = getAllAnnouncedNumbers(ticket);
        if (winningNumbs.size() == TambolaConstants.JALDI_FIVE_VALUE) {
            printWinningNumbers(winningNumbs, "Jaldi Five");
            retFlag = true;
            isProcessed = true;
        }
        return retFlag;
    }

    public List<Integer> getAllAnnouncedNumbers(Ticket ticket) {
        List<Integer> winningNumbs = new ArrayList<>();
        for (int row = 0; row < ticket.getCell().length; row++) {
            for (int col = 0; col < ticket.getCell()[1].length; col++) {
                Cell cell = ticket.getCell()[row][col];

                if (cell.isAnnounced()) {
                    winningNumbs.add(cell.getVal());

                    if (winningNumbs.size() == TambolaConstants.JALDI_FIVE_VALUE) {
                        return winningNumbs;
                    }
                }
            }
        }
        return winningNumbs;
    }

}
