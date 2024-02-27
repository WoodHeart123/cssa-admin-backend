package org.cssa.admin.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


@Data
public class Propaganda {

    private Integer id;
    private Timestamp publishedAt;
    private Integer creator;
    private List<Integer> assignees;
    private String assigneesJSON;
    private String textLink;
    private String previewLink;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
}
