package com.crud.tasks.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class BadgesTest {

    @Test
    public void testBadgesTest() {
        Badges badges = new Badges(1,new AttachmentsByType(new Trello(1,3)));

        assertEquals(1, badges.getVotes());
        assertEquals(1, badges.getAttachmentsByType().getTrello().getBoard());
        assertEquals(3, badges.getAttachmentsByType().getTrello().getCard());
    }
}