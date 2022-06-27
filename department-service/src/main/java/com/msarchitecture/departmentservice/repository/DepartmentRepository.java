package com.msarchitecture.departmentservice.repository;

import com.msarchitecture.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentBydepartmentId(Long departmentId);
}
