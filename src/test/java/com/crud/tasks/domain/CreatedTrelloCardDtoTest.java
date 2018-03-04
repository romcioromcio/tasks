package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CreatedTrelloCardDtoTest {

    @Test
    public void getCreatedTrelloCardDto() {
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Romcio", "http://test.com");

        assertEquals("1",createdTrelloCardDto.getId() );
        assertEquals("Romcio", createdTrelloCardDto.getName());
        assertEquals("http://test.com", createdTrelloCardDto.getShortUrl());
    }
}