package com.k0ft3.atman.model.processmodel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.k0ft3.atman.model.processmodel.taskmodel.TaskChange;

import lombok.Data;

@Data
public class Task {

    private String id;
    private String taskTitle;
    private String tastContent;
    private String importanceFlag;
    private String creationDate;
    private List<TaskChange> changedDates = new ArrayList<>();
}