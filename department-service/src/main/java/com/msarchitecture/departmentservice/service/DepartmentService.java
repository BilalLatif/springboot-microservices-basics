package com.msarchitecture.departmentservice.service;

import com.msarchitecture.departmentservice.entity.Department;
import com.msarchitecture.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentBydepartmentId(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return  departmentRepository.findDepartmentBydepartmentId(departmentId);
    }
}
