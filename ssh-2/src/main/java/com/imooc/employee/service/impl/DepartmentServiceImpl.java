package com.imooc.employee.service.impl;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门管理的业务层的实现类
 *
 * @author Arsenal
 * created on 2019/2/25 0:45
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    // 注入部门管理的DAO:
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    // 分页查询部门的方法
    @Override
    public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<>();
        // 封装当前的页：
        pageBean.setCurrPage(currPage);
        // 封装每页显示记录数：
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 封装总记录数：
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 封装总页数：
        Double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 封装每页显示的数据：
        int begin = (currPage - 1) * pageSize;
        List<Department> list =  departmentDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    // 业务层保存部门的方法
    @Override
    public void save(Department department) {
        departmentDao.save(department);

    }

    // 业务层根据部门的ID查询部门的方法
    @Override
    public Department findById(Integer did) {
        return departmentDao.findById(did);
    }

    // 业务层修改部门的方法
    @Override
    public void update(Department department) {
        System.out.println("update service");
        departmentDao.update(department);
    }

    // 业务层删除部门的方法
    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    // 查询所有部门的方法
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
