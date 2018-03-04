package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloTest {

    @Test
    public void testTrelloTest() {
        //Given
        Trello trello = new Trello(1,2);

        //When
        int trelloboard = trello.getBoard();

        //Then
        assertEquals(1,trelloboard);
    }

}