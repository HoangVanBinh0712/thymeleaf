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
public class GetManagerDto {

    private String employeeCode;

    private String employeeName;

    private Boolean selected;
}
