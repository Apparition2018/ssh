package cn.imooc.ssh.mydialect;

import org.hibernate.dialect.MySQL55Dialect;

/**
 * 重写MySQL5InnoDBDialect
 *
 * @author Arsenal
 * created on 2019/2/24 1:25
 */
public class MyDialect extends MySQL55Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
