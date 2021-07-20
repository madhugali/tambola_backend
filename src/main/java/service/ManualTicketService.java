package service;

import pojo.Cell;
import pojo.Ticket;

import java.util.Scanner;

public class ManualTicketService implements TicketService {

    private int rowSize;
    private int colSize;
    private Scanner scan;

    public ManualTicketService(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.scan = new Scanner(System.in);
    }

    @Override
    public Ticket generateTicket() {
        Cell[][] cell = new Cell[this.rowSize][this.colSize];
        for (int row = 0; row < this.rowSize; row++) {
            System.out.println("Enter row " + (row + 1) + " values");
            for (int col = 0; col < this.colSize; col++) {
                scan = new Scanner(System.in);
                int input = scan.nextInt();
                cell[row][col] = new Cell(input, false);
            }
        }
        return new Ticket(cell);
    }

}
