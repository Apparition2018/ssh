package com.imooc.employee.dao.impl;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.domain.Department;
import com.imooc.employee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门管理的业务层的类
 *
 * @author Arsenal
 * created on 2019/2/25 0:47
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private HibernateUtil hibernateUtil;

    private Session session;

    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public int findCount() {
        // 配置IDEA，使其识别hql
        // https://blog.csdn.net/qq_40987088/article/details/80044723
        String hql = "select count(*) from Department";
        session = hibernateUtil.getSession();
        Query query = session.createQuery(hql);
        int count = ((Long) query.uniqueResult()).intValue();
        if (count > 0) {
            return count;
        }
        hibernateUtil.closeSession(session);
        return 0;

    }

    /**
     * 分页查询部门
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Department> findByPage(int begin, int pageSize) {
        String hql = "from Department";
        session = hibernateUtil.getSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Department> list = query.list();
        hibernateUtil.closeSession(session);
        return list;
    }

    /**
     * DAO中保存部门的方法
     */
    @Override
    public void save(Department department) {
        session = hibernateUtil.getSession();
        session.save(department);
        hibernateUtil.closeSession(session);
    }

    /**
     * DAO中根据部门的ID查询部门的方法
     */
    @Override
    public Department findById(Integer did) {
        session = hibernateUtil.getSession();
        Department department = session.get(Department.class, did);
        hibernateUtil.closeSession(session);
        return department;
    }

    /**
     * DAO中修改部门的方法
     */
    @Override
    public void update(Department department) {
        session = hibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(department);
        transaction.commit();
        hibernateUtil.closeSession(session);
    }

    /**
     * DAO中删除部门的方法
     */
    @Override
    public void delete(Department department) {
        session = hibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(department);
        transaction.commit();
        hibernateUtil.closeSession(session);
    }

    /**
     * DAO中查询所有部门的方法
     */
    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        session = hibernateUtil.getSession();
        Query query = session.createQuery(hql);
        List<Department> list = query.list();
        hibernateUtil.closeSession(session);
        return list;
    }
}
