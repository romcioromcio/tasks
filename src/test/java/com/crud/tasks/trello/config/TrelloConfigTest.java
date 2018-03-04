package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class TrelloConfigTest {
    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void getUserName() {
        TrelloConfig trelloConfig = new TrelloConfig();

        String userName = trelloConfig.getUserName();

        System.out.println(userName);
    }
    @Test
    public void getTrelloAppKey() {
        TrelloConfig trelloConfig = new TrelloConfig();

        String trelloAppKey = trelloConfig.getTrelloAppKey();

        System.out.println(trelloAppKey);
    }

    @Test
    public void getTrelloToken() {
        TrelloConfig trelloConfig = new TrelloConfig();

        String trelloToken = trelloConfig.getTrelloToken();

        System.out.println(trelloToken);
    }

    @Test
    public void getTrelloApiEndpoint() {
        TrelloConfig trelloConfig = new TrelloConfig();

        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();

        System.out.println(trelloApiEndpoint);
    }
}