package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {

    private Cell[][] cell;

    public void printTicket() {
        System.out.println("-------------------- Your Ticket ------------------------------");
        for (int row = 0; row < this.getCell().length; row++) {
            for (int col = 0; col < this.getCell()[1].length; col++) {
                System.out.print(this.getCell()[row][col].getVal() + "\t");
            }
            System.out.print("\n");
        }
    }

    public void markAnnouncedNumbers(int ip) {
        for (int row = 0; row < this.getCell().length; row++) {
            for (int col = 0; col < this.getCell()[1].length; col++) {
                Cell cell = this.getCell()[row][col];
                int cellVal = cell.getVal();
                if (cellVal == ip) {
                    cell.setAnnounced(Boolean.TRUE);
                    cell.setVal(-ip);
                    System.out.println("Marked number " + ip);
                } else if (cellVal == -ip) {
                    System.out.println(" Error, number " + ip + " is called twice!!");
                }
            }
        }
    }

}
