package com.k0ft3.atman.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.k0ft3.atman.model.processmodel.UserRole;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Process")
@Data
public class Process {
    // process id will be genereated after import or creation
    private String processId;
    private Date processCreationOrImportDate;
    // name will deleted with export
    private String processName;
    private String processAdminId;
    // key can be generated for public sharing
    private String generatablePublicProcessKey;
    private List<UserRole> userRoleList = new ArrayList<>();
    private List<String> userIdList = new ArrayList<>();

}