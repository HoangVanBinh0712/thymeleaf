package org.demo_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private String departmentCode;

    private String departmentName;

    private String description;

    private String address;

    private Integer deleteFlag;

    private String createdBy;

    private Timestamp createdDatetime;

    private String updatedBy;

    private Timestamp updatedDatetime;

    private Boolean selected;

}
