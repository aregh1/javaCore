package com.optym.hr.dao;

/**
 * Created by Areg on 7/2/2017.
 */
public interface Employee {
    int add(Employee employee);
    void delete(Employee employee);
    Employee getEmployee(String userName, String password);
    void setEmployee(Employee employee);
}
