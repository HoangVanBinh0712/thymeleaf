package org.demo_thymeleaf.service;

import org.demo_thymeleaf.entity.DepartmentEntity;
import org.demo_thymeleaf.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentEntity> getDepartment() {
        return departmentRepository.findAll();
    }

}
