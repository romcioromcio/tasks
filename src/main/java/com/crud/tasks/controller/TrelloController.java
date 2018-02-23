package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
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
    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloService.createdTrelloCard(trelloCardDto);
    }
}