package org.demo_thymeleaf.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeForm {

    @Size(max = 20)
    private String employeeCode;

    @NotBlank
    @Size(max = 50)
    private String employeeName;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birth;

    @NotBlank
    @Size(max = 200)
    private String email;

    private Integer isManager;

    @Size(max = 20)
    private String managerCode;

    @Size(max = 20)
    @NotBlank
    private String departmentCode;

    private Integer deleteFlag;

}
