package org.jetbrains.kotlinx.tictactoe;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testValidPosition(){
        for (int i = 1; i <=9; i++) {
            int finalI = i;
            assertDoesNotThrow(() -> new Position(finalI));
        }
    }

    @Test
    void testPositionZero() {
        assertThrows(IllegalArgumentException.class, () -> new Position(0));
    }

    @Test
    void testPositionTen() {
        assertThrows(IllegalArgumentException.class, () -> new Position(10));
    }

    @Test
    void testToRow() {
        assertEquals(0, new Position(1).toRow());
        assertEquals(0, new Position(3).toRow());
        assertEquals(1, new Position(5).toRow());
        assertEquals(2, new Position(9).toRow());
    }

    @Test
    void testToColumn() {
        assertEquals(0, new Position(1).toColumn());
        assertEquals(2, new Position(3).toColumn());
        assertEquals(1, new Position(5).toColumn());
        assertEquals(2, new Position(9).toColumn());
    }

}
