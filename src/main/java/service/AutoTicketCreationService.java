package service;

import pojo.Cell;
import pojo.Ticket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoTicketCreationService implements TicketService {

    private final List<Integer> indexLs = constructRange(0, 8);
    private final List<Integer> zeroLs = constructRange(1, 9);
    private final List<Integer> oneIndexLs = constructRange(10, 19);
    private final List<Integer> twoIndexLs = constructRange(20, 29);
    private final List<Integer> threeIndexLs = constructRange(30, 39);
    private final List<Integer> fourthIndexLs = constructRange(40, 49);
    private final List<Integer> fiveIndexLs = constructRange(50, 59);
    private final List<Integer> sixIndexLs = constructRange(60, 69);
    private final List<Integer> sevenIndexLs = constructRange(70, 79);
    private final List<Integer> eightIndexLs = constructRange(80, 90);
    private final Random random = new Random();

    private static final int ROW_SIZE = 3;
    private static final int COL_SIZE = 9;

    @Override
    public Ticket generateTicket() {
        Map<Integer, List<Integer>> rangeMap = constructRangeMap();

        Cell[][] cell = new Cell[ROW_SIZE][COL_SIZE];
        for (int row = 0; row < ROW_SIZE; row++) {
            List<Integer> removalIndexes = getRemovalIndexes(indexLs);
            for (int col = 0; col < COL_SIZE; col++) {
                int input = 0;
                if (!removalIndexes.contains(col)) {
                    List<Integer> indexesLs = rangeMap.get(col);
                    int removableIndex = random.nextInt(indexesLs.size() - 1);
                    Integer removedVal = indexesLs.remove(removableIndex);
                    rangeMap.put(col, indexesLs);
                    input = removedVal;
                }
                cell[row][col] = new Cell(input, false);
            }
        }
        return new Ticket(sortColumnsOfTicket(cell));
    }

    private Cell[][] sortColumnsOfTicket(Cell[][] cell) {
        for (int col = 0; col < cell[1].length; col++) {

            Cell[] cells = {cell[0][col], cell[1][col], cell[2][col]};
            for (int i = 0; i < cells.length; i++) {
                for (int j = i + 1; j < cells.length; j++) {

                    Cell initialIndexElement = cells[i];
                    Cell nextIndexElement = cells[j];

                    int initialIndexElementValue = initialIndexElement.getVal();
                    int nextIndexElementValue = nextIndexElement.getVal();
                    if (initialIndexElementValue != 0 && nextIndexElementValue != 0) {
                        if (nextIndexElementValue < initialIndexElementValue) {
                            Cell tempElement = initialIndexElement;
                            cells[i] = nextIndexElement;
                            cells[j] = tempElement;
                        }
                    }
                }
            }

            cell[0][col] = cells[0];
            cell[1][col] = cells[1];
            cell[2][col] = cells[2];
        }
        return cell;
    }

    private Map<Integer, List<Integer>> constructRangeMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, zeroLs);
        map.put(1, oneIndexLs);
        map.put(2, twoIndexLs);
        map.put(3, threeIndexLs);
        map.put(4, fourthIndexLs);
        map.put(5, fiveIndexLs);
        map.put(6, sixIndexLs);
        map.put(7, sevenIndexLs);
        map.put(8, eightIndexLs);
        return map;
    }

    private List<Integer> getRemovalIndexes(List<Integer> indexLs) {
        List<Integer> tempIndexLs = new ArrayList<>(indexLs);
        int TOTAL_BLANKS = 4;
        return IntStream
                .range(0, TOTAL_BLANKS)
                .map(e1 -> tempIndexLs.remove(random.nextInt(tempIndexLs.size() - 1)))
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> constructRange(int statIndex, int endIndex) {
        return IntStream.rangeClosed(statIndex, endIndex).boxed().collect(Collectors.toList());
    }

}