package com.crud.tasks.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class AttachmentsByTypeTest {

    @Test
    public void getTrello() {
        AttachmentsByType attachmentsByType = new AttachmentsByType(new Trello(1, 3));

        assertEquals(1, attachmentsByType.getTrello().getBoard());
        assertEquals(3, attachmentsByType.getTrello().getCard());
    }
}