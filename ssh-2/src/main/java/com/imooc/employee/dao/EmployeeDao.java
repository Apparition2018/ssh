package com.imooc.employee.dao;

import com.imooc.employee.domain.Employee;

import java.util.List;

/**
 * 员工管理的DAO的接口
 *
 * @author Arsenal
 * created on 2019/2/24 23:05
 */
public interface EmployeeDao {

    Employee findByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, int pageSize);
}
