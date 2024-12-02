package org.demo_thymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTMENT")
public class DepartmentEntity {

    @Id
    private String departmentCode;

    private String departmentName;

    private String description;

    private String address;

    private Integer deleteFlag;

    private String createdBy;

    private Timestamp createdDatetime;

    private String updatedBy;

    private Timestamp updatedDatetime;
}
