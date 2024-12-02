package org.demo_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeParamDto {

    private String empCode;

    private String empName;

    private String managerCode;

    private String departmentCode;

}
