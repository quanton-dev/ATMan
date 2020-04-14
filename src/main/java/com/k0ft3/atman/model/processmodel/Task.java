package com.k0ft3.atman.model.processmodel;

import java.sql.Date;

import lombok.Data;

@Data
public class Task {

    private String id;
    private String taskTitle;
    private String tastContent;
    private String importanceFlag;
    private Date creationDate;
    private Date lastChangeDate;
}