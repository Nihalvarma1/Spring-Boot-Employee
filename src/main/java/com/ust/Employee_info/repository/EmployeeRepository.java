package com.ust.Employee_info.repository;

import com.ust.Employee_info.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {

    List<EmployeeModel> findByGrade(char grade);

    List<EmployeeModel> findByBasicSalaryBetween(int begin,int end);
}
