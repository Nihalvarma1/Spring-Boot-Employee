package com.ust.Employee_info.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int basicSalary;
    @Column
    private char grade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModel that = (EmployeeModel) o;
        return getGrade() == that.getGrade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGrade());
    }
}
