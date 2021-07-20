package main;

import pojo.Ticket;
import service.TicketService;
import service.WinningScenarios;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {

    private final TicketService ticketService;
    private final Scanner scanner;
    private final List<WinningScenarios> scenarios;

    public Game(TicketService ticketService, List<WinningScenarios> scenarios) {
        this.ticketService = ticketService;
        this.scenarios = scenarios;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        Ticket ticket = this.ticketService.generateTicket();
        ticket.printTicket();

        String gameStatus = beginGame(ticket);
        if (gameStatus.equalsIgnoreCase("n")) {
            System.out.println("Press g to start a new game! or press any key to exit");
            String userIp = scanner.next();
            if (userIp.equalsIgnoreCase("g")) {
                play();
            }
        }
    }

    private String beginGame(Ticket ticket) {
        String userInput = "y";
        while (userInput.equalsIgnoreCase("y")) {
            System.out.println("Enter announced number! or type n to quit the game");
            String numInput = scanner.next();

            if (numInput.matches("^[0-9]*$")) {
                ticket.markAnnouncedNumbers(Integer.parseInt(numInput));
                ticket.printTicket();

                List<Boolean> winningsStatus = scenarios
                        .stream()
                        .map(e1 -> e1.checkIfWon(ticket)).collect(Collectors.toList());
                Optional<Boolean> hasAnyWinningFailed = winningsStatus.stream().filter(e1 -> !e1).findFirst();
                if (!hasAnyWinningFailed.isPresent()) {
                    System.out.println("Congratulations you have won the Housie");
                    userInput = "n";
                }
            } else if (numInput.equalsIgnoreCase("n")) {
                userInput = numInput;
            }
        }
        return userInput;
    }

}
