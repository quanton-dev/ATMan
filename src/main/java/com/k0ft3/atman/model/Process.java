package com.k0ft3.atman.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.k0ft3.atman.model.processmodel.Task;
import com.k0ft3.atman.model.processmodel.UserRole;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "Process")
@Data
@AllArgsConstructor
public class Process {
    // process id will be genereated after import or creation
    private String id;

    private String processCreationOrImportDate;
    // name will deleted with export
    private String processName;
    private String processAdminId;
    // key can be generated for public sharing
    private String generatablePublicProcessKey;
    private List<UserRole> userRoleList = new ArrayList<>();
    private List<String> userIdList = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public Process(String processCreationOrImportDate, String processName, String processAdminId,
            String generatablePublicProcessKey, List<UserRole> userRoleList, List<String> userIdList,
            List<Task> tasks) {
        this.processCreationOrImportDate = processCreationOrImportDate;
        this.processName = processName;
        this.processAdminId = processAdminId;
        this.generatablePublicProcessKey = generatablePublicProcessKey;
        this.userRoleList = userRoleList;
        this.userIdList = userIdList;
        this.tasks = tasks;
    }
}