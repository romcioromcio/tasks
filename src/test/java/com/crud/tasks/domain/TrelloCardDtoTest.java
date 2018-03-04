package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloCardDtoTest {

    @Test
    public void shuldTrelloCardDtoTest() {

        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "abc","xvc", "1");

        //When
        String trellocard = trelloCardDto.getName();

        //Then
        assertEquals("Test", trellocard);
    }
}