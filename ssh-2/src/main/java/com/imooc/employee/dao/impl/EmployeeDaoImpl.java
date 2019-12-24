package com.imooc.employee.dao.impl;

import com.imooc.employee.dao.EmployeeDao;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工管理的DAO的实现类
 *
 * @author Arsenal
 * created on 2019/2/24 23:06
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    private HibernateUtil hibernateUtil;

    private Session session;

    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    /**
     * DAO中根据用户名和密码查询用户的方法:
     */
    @Override
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql = "from Employee where username = ?1 and password = ?2";
        session = hibernateUtil.getSession();
        Query query = session.createQuery(hql);
        query.setParameter(1, employee.getUsername());
        query.setParameter(2, employee.getPassword());
        List<Employee> lists = query.list();
        if (lists.size() > 0) {
            return lists.get(0);
        }
        hibernateUtil.closeSession(session);
        return null;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Employee";
        session = hibernateUtil.getSession();
        Query query = session.createQuery(hql);
        int count = ((Long) query.setCacheable(true).uniqueResult()).intValue();
        if (count > 0) {
            return count;
        }
        hibernateUtil.closeSession(session);
        return 0;
    }

    @Override
    public List<Employee> findByPage(int begin, int pageSize) {
        String hql = "from Employee";
        session = hibernateUtil.getSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Employee> list = query.list();
        hibernateUtil.closeSession(session);
        return list;
    }
}
