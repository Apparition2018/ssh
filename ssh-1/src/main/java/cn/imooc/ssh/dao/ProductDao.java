package cn.imooc.ssh.dao;

import cn.imooc.ssh.domain.Product;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 商品管理的DAO的类
 *
 * @author Arsenal
 * created on 2019/2/23 23:06
 */
public class ProductDao extends HibernateDaoSupport {


    /**
     * DAO中的保存商品的方法
     *
     * @param product
     */
    public void save(Product product) {
        System.out.println("DAO中的save方法执行了...");
        this.getHibernateTemplate().save(product);
    }
}
