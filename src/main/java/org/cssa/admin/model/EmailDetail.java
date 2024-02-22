package org.cssa.admin.model;


import lombok.Data;

import java.util.ArrayList;

@Data
public class EmailDetail {
    private ArrayList<String> receiver;
    private String message;
    private String subject;
    // not available
    //private String attachment;
}
