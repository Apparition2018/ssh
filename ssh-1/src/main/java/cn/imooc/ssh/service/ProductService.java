package cn.imooc.ssh.service;

import cn.imooc.ssh.dao.ProductDao;
import cn.imooc.ssh.domain.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品管理的业务层的类
 *
 * @author Arsenal
 * created on 2019/2/23 23:06
 */
@Transactional
public class ProductService {

    // 业务层注入DAO的类
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * 业务层保存商品的方法
     * @param product
     */
    public void save(Product product) {
        System.out.println("Service中的save方法执行了...");
        productDao.save(product);
    }
}
