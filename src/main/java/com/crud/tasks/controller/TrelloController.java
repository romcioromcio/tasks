package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloFacade.createCard(trelloCardDto);
    }
        //trelloBoards.forEach(trelloBoardDto -> {
            //System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
            //System.out.println("This board contains lists: ");
           // trelloBoardDto.getLists().forEach(trelloList ->
                    //System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
       // });
    //public List<TrelloBoardDto> getTrelloBoards() {
        //List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
       //trelloBoards=trelloBoards.stream().
                //filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla")).
                //filter(trelloBoardDto -> !trelloBoardDto.getId().isEmpty()).
                //filter(trelloBoardDto -> !trelloBoardDto.getName().isEmpty()).
                //map(t -> {
                    //System.out.println(t.getId() + " " + t.getName());
                    //return t;
                //}).
                //collect(Collectors.toList());
        //return trelloBoards;
    //}

}