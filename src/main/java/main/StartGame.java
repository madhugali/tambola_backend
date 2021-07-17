package main;

import service.*;

import java.util.Arrays;
import java.util.List;

public class StartGame {

    public static void main(String[] args) {
        List<WinningScenarios> scenarios = Arrays
                .asList(new JaldiFive(), new FirstRow(), new SecondRow(), new ThirdRow());
        Game game = new Game(new ManualTicketService(3, 9), scenarios);
        game.play();
    }

}
