package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloListTest {

    @Test
    public void shouldTrelloListTest(){

        //Given
        TrelloList trelloList = new TrelloList("1","Test TrelloList", true);

        //When
        String trelloName = trelloList.getName();

        //Then
        assertEquals("Test TrelloList", trelloName);

    }

}