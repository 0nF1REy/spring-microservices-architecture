package dev.alanryan.studentservice.api.dto;

import lombok.Data;

@Data
public class Course {
    private Long cid;
    private String cname;
    private String cdescription;
}
