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
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    private String employeeCode;

    private String employeeName;

    private Date birth;

    private String email;

    private Integer isManager;

    private String managerCode;

    private String departmentCode;

    private Integer deleteFlag;

    private String createdBy;

    private Timestamp createdDatetime;

    private String updatedBy;

    private Timestamp updatedDatetime;

}
