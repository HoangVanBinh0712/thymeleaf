package org.demo_thymeleaf.service;

import org.demo_thymeleaf.dto.Employee;
import org.demo_thymeleaf.dto.GetEmployeeParamDto;
import org.demo_thymeleaf.dto.IEmployee;
import org.demo_thymeleaf.dto.IGetManagerDto;
import org.demo_thymeleaf.entity.EmployeeEntity;
import org.demo_thymeleaf.repository.EmployeeRepository;
import org.demo_thymeleaf.util.CommonFunc;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeService {
    private final ModelMapper mapper;

    private final EmployeeRepository employeeRepository;


    public EmployeeService(ModelMapper mapper, EmployeeRepository employeeRepository) {
        this.mapper = mapper;
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee(GetEmployeeParamDto param) {
        List<IEmployee> employees = employeeRepository.getEmployee(param);
        return employees.stream().map(item -> mapper.map(item, Employee.class)).toList();
    }

    public List<IGetManagerDto> getEmployeeManager() {
        return employeeRepository.getEmployeeManager();
    }

    @Transactional
    public void insertEmployee(EmployeeEntity entity) {
        String nextCode = generateNextEmployeeCode();
        entity.setEmployeeCode(nextCode);
        entity.setCreatedBy("Admin");
        entity.setCreatedDatetime(Timestamp.valueOf(LocalDateTime.now()));
        employeeRepository.save(entity);
    }

    @Transactional
    public void updateEmployee(EmployeeEntity entity) {
        entity.setUpdatedBy("Admin");
        entity.setUpdatedDatetime(Timestamp.valueOf(LocalDateTime.now()));
        employeeRepository.save(entity);
    }

    public String generateNextEmployeeCode() {
        long nextSeq = employeeRepository.getNextSeq();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String ymd = LocalDateTime.now().format(dateTimeFormatter);
        String numStr = String.format("%012d", nextSeq);
        return ymd + numStr;
    }
}
