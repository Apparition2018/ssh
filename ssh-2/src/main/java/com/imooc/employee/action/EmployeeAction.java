package com.imooc.employee.action;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.imooc.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 员工管理的Action类
 *
 * @author Arsenal
 * created on 2019/2/24 23:01
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    // 模型驱动使用的对象
    private Employee employee = new Employee();

    @Override
    public Employee getModel() {
        return employee;
    }

    // 注入业务层类：
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 接受当前页数
    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 登录执行的方法：
     */
    public String login() {
        System.out.println("login执行了...");
        // 调用业务层的类
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null) {
            // 登录失败
            this.addActionError("用户名或密码错误!");
            return INPUT;
        } else {
            // 登录成功
            ActionContext.getContext().getSession().put("existEmployee", existEmployee);
            return SUCCESS;
        }
    }

    /**
     * 分页查询员工的执行的方法：
     */
    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     * 跳转到添加员工页面执行的方法：
     */
    public String saveUI() {
        // 查询所有部门
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list); // 集合用set，对象用push
        return "saveUI";
    }

}
