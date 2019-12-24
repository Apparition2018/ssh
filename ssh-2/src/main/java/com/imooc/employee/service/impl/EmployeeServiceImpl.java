package com.imooc.employee.service.impl;

import com.imooc.employee.dao.EmployeeDao;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.EmployeeService;

import java.util.List;

/**
 * 员工管理的业务层实现类
 *
 * @author Arsenal
 * created on 2019/2/24 23:04
 */
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 业务层的登录的方法
     */
    @Override
    public Employee login(Employee employee) {
        return employeeDao.findByUsernameAndPassword(employee);
    }

    /**
     * 业务层的分页查询员工的方法
     */
    @Override
    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<>();
        // 封装当前的页数：
        pageBean.setCurrPage(currPage);
        // 封装每页显示的记录数：
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 封装总记录数：
        int totalCount = employeeDao.findCount();
        pageBean.setTotalPage(totalCount);
        // 封装总的页数：
        Double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 封装每页显示的数据：
        int begin = (currPage - 1) * pageSize;
        List<Employee> list = employeeDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
