package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    private static class TestPlayer extends Player {

        /**
         * Creates a new player.
         *
         * @param name the player's name
         * @param mark the player's mark (X or O)
         * @throws IllegalArgumentException if mark is EMPTY
         */
        public TestPlayer(String name, Mark mark) {
            super(name, mark);
        }

        @Override
        public Position chooseMove(Board board) {
            return board.getAvailablePositions().get(0);
        }
    }

    @Test
    public void testCreatePlayerWithValidMark(){
        Player player =new TestPlayer("Test",Mark.O);

        assertEquals("Test",player.getName());
        assertEquals(Mark.O,player.getMark());
    }

    @Test
    public void testCreatePlayerWithInvalidMark(){

        assertThrows(IllegalArgumentException.class, () -> new TestPlayer("Test",Mark.EMPTY));

    }

}
