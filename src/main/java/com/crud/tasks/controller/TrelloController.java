package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.ObjectInputFilter;

import javax.persistence.Id;
import javax.print.DocFlavor;
import javax.validation.constraints.NotNull;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards=trelloBoards.stream().
                filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla")).
                filter(trelloBoardDto -> !trelloBoardDto.getId().isEmpty()).
                filter(trelloBoardDto -> !trelloBoardDto.getName().isEmpty()).
                map(t -> {
                    System.out.println(t.getId() + " " + t.getName());
                    return t;
                }).
                collect(Collectors.toList());
        return trelloBoards;
    }
}