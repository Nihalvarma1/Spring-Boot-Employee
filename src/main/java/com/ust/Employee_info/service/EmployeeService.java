package com.ust.Employee_info.service;

import com.ust.Employee_info.model.EmployeeModel;
import com.ust.Employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        return repo.save(employeeModel);
    }

    public List<EmployeeModel> listEmployees() {
        return repo.findAll();
    }

    public List<EmployeeModel> addEmployees(List<EmployeeModel> employeeModels) {
        return repo.saveAll(employeeModels);
    }

    public EmployeeModel getEmployee(int id) {
        return repo.findById(id).orElse(null);
    }

    public EmployeeModel updateEmployee(int id, EmployeeModel employeeModel) {
        EmployeeModel existingEmployee = repo.findById(id).orElse(null);
        existingEmployee.setName(employeeModel.getName());
        existingEmployee.setBasicSalary(employeeModel.getBasicSalary());
        existingEmployee.setGrade(employeeModel.getGrade());
        repo.save(existingEmployee);
        return employeeModel;
    }

    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return "Employee Deleted with id: "+id;
    }

    public List<EmployeeModel> getEmployeesByGrade(char grade){
        return repo.findByGrade(grade);
    }

    public List<EmployeeModel> getEmployeesWithinRangedSalary(int start,int end){
        return repo.findByBasicSalaryBetween(start, end);
    }
}
