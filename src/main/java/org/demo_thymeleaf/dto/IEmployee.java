package org.demo_thymeleaf.dto;

public interface IEmployee {

    String getEmployeeCode();

    String getEmployeeName();

    java.sql.Timestamp getBirth();

    String getEmail();

    Integer getIsManager();

    String getManagerCode();

    String getDepartmentCode();

    Integer getDeleteFlag();

    String getCreatedBy();

    java.sql.Timestamp getCreatedDatetime();

    String getUpdatedBy();

    java.sql.Timestamp getUpdatedDatetime();

    String getManagerName();

    String getDepartmentName();

}
