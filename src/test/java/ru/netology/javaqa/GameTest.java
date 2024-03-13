package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {

    Player player1 = new Player(73, "Dragon", 555);
    Player player2 = new Player(18, "LadyBird", 209);
    Player player3 = new Player(5, "XU", 1053);
    Player player4 = new Player(90, "Evelin", 756);
    Player player5 = new Player(384, "J", 2004);

    Game game = new Game();

    @Test
    public void shouldToRegisterPlayers() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        System.out.println(game);

    }

    @Test
    public void shouldThrewExceptionIfNobodyIsRegistered() {


        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NoRegisteredException.class, () -> {
            game.round("Strager", "Tiger");
        });
    }

    @Test
    public void shouldThrewExceptionIfOneIsNotRegistered() {


        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NoRegisteredException.class, () -> {
            game.round("Strager", "J");
        });
    }

    @Test
    public void shouldWinTheFirstPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round("XU", "Dragon");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinTheSecondPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("LadyBird", "Evelin");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEquals() {
        Player player6 = new Player(394, "Katana", 555);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 0;
        int actual = game.round("Katana", "Dragon");
        Assertions.assertEquals(expected, actual);
    }
}








