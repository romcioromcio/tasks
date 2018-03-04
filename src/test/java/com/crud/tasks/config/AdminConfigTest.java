package com.crud.tasks.config;


import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

public class AdminConfigTest {
    @Autowired
    AdminConfig adminConfig;

    @Test
    public void getAdminMailTest() {
        AdminConfig adminConfig = new AdminConfig();

        String adminMail = adminConfig.getAdminMail();

        System.out.println(adminMail);
    }
}