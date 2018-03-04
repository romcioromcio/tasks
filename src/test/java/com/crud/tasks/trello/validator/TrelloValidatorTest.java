package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void validateCard() {
    }

    @Test
    public void validateTrelloBoardsTest() {

        //Given
        TrelloList trelloList1 = new TrelloList("1","Test list 1", true);
        TrelloList trelloList2 = new TrelloList("2", "Test list 2", false);

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(trelloList1);
        trelloList.add(trelloList2);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "Boards", trelloList);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);

        //When
        List<TrelloBoard> filterTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(0, filterTrelloBoards.size());
    }
}