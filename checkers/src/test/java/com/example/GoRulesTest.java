package com.example;
import com.example.model.*; 
import com.example.rules.*;
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;


public class GoRulesTest {
    @Test
    void placeStoneOnOccupiedShouldFail() {
        Board b = new Board(5);
        Rules rules = new GoRules();

        b.set(2, 2, Stone.BLACK);
        
        MoveResult r = rules.applyMove(b, 2, 2, Stone.WHITE);

        assertFalse(r.isOk());
        assertEquals("Pole zajete", r.getErrorMessage());
    }



    @Test
    void surroundedSingleStoneShouldBeCaptured() {
        Board b = new Board(3);
        Rules rules = new GoRules();
        // ustawiamy białego kamienia
        b.set(1, 1, Stone.WHITE);
        System.out.println(b);

        // otaczamy go czarnymi z trzech stron
        b.set(0, 1, Stone.BLACK);
        b.set(2, 1, Stone.BLACK);
        b.set(1, 0, Stone.BLACK);
        System.out.println(b);

        // ostatni ruch czarnego zamyka oddechy białego
        //MoveResult r = b.placeStone(1, 2, Stone.BLACK);
        MoveResult r = rules.applyMove(b, 1, 2, Stone.BLACK);
        System.out.println(b);


        assertTrue(r.isOk(), "Ruch powinien być poprawny");
        assertEquals(1, r.getCaptures().size(), "Powinien zostać zbity dokładnie 1 kamień");

        // sprawdzamy, że kamień został usunięty z planszy
        Board after = r.getBoardSnapshot();
        assertEquals(Stone.EMPTY, after.get(1, 1));
    }
}
