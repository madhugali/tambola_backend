package main;

import pojo.Ticket;
import service.AutoTicketCreationService;

import java.util.stream.IntStream;

public class TicketGenerator {

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(e1 -> {
            Ticket ticket = new AutoTicketCreationService().generateTicket();
            ticket.printTicket();
        });
    }

}
