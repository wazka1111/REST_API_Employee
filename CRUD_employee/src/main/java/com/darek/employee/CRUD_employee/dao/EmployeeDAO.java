package com.darek.employee.CRUD_employee.dao;

import com.darek.employee.CRUD_employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
