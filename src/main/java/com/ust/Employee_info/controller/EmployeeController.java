package com.ust.Employee_info.controller;

import com.ust.Employee_info.model.EmployeeModel;
import com.ust.Employee_info.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel){
        return employeeService.addEmployee(employeeModel);
    }

    @PostMapping("/addEmployees")
    public List<EmployeeModel> addEmployees(@RequestBody List<EmployeeModel> employeeModel){
        return employeeService.addEmployees(employeeModel);
    }

    @GetMapping("/listEmployees")
    public List<EmployeeModel> listEmployees(){
        return employeeService.listEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public EmployeeModel getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }
    @PutMapping("/updateEmployee/{id}")
    public EmployeeModel updateEmployee(@PathVariable int id,@RequestBody EmployeeModel employeeModel){
        return employeeService.updateEmployee(id,employeeModel);
    }

    @GetMapping("/getEmployeesByGrade/{grade}")
    public List<EmployeeModel> getEmployeesByGrade(@RequestParam char grade){
        return employeeService.getEmployeesByGrade(grade);
    }

    @GetMapping("/getEmployeesWithinRangedSalary/{start}/{end}")
    public List<EmployeeModel> getEmployeesWithinRangedSalary(@RequestParam int start, @RequestParam int end){
        return employeeService.getEmployeesWithinRangedSalary(start, end);
    }
}
