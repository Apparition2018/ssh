package com.imooc.employee.service;

import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;

/**
 * 员工管理的业务层接口
 *
 * @author Arsenal
 * created on 2019/2/24 23:03
 */
public interface EmployeeService {

    Employee login(Employee employee);

    PageBean<Employee> findByPage(Integer currPage);
}
