package com.crud.tasks.domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    //private String toCc;
    private String mailType;

}
