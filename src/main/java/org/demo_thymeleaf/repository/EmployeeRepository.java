package org.demo_thymeleaf.repository;

import org.demo_thymeleaf.dto.GetEmployeeParamDto;
import org.demo_thymeleaf.dto.GetManagerDto;
import org.demo_thymeleaf.dto.IEmployee;
import org.demo_thymeleaf.dto.IGetManagerDto;
import org.demo_thymeleaf.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

    @Query(value = """
             SELECT E.*,
                           M.EMPLOYEE_NAME AS  MANAGER_NAME,
                           D.DEPARTMENT_NAME
                    FROM EMPLOYEE E
                             LEFT JOIN EMPLOYEE M ON E.MANAGER_CODE = M.EMPLOYEE_CODE
                             LEFT JOIN DEPARTMENT D ON E.DEPARTMENT_CODE = D.DEPARTMENT_CODE
                    WHERE 1 = 1
                    AND (:#{#param.empCode} IS NULL OR E.EMPLOYEE_CODE = :#{#param.empCode})
                    AND (:#{#param.empName} IS NULL OR E.EMPLOYEE_NAME LIKE CONCAT(CONCAT('%', :#{#param.empName}), '%'))
                    AND (:#{#param.managerCode} IS NULL OR E.MANAGER_CODE = :#{#param.managerCode})
                    AND (:#{#param.departmentCode} IS NULL OR E.DEPARTMENT_CODE = :#{#param.departmentCode})
                
            """, nativeQuery = true)
    List<IEmployee> getEmployee(@Param("param") GetEmployeeParamDto param);

    @Query(value = "SELECT DISTINCT employee_code, employee_name, 1 AS selected FROM EMPLOYEE WHERE is_manager = 1", nativeQuery = true)
    List<IGetManagerDto> getEmployeeManager();

    @Query(value = "SELECT SEQ_EMPLOYEE.NEXTVAL FROM DUAL", nativeQuery = true)
    long getNextSeq();
}