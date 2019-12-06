package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;




import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TxTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

    /**
     * 将emp_id=5的记录的salary字段更新为1300.00
     */
    @Test
    public void test02(){
        String sql = "update employee set salary=? where emp_id=?";
        int update = jdbcTemplate.update(sql, 1300.00, 5);
        System.out.println("更改员工:"+update);
    }

    @Test
    public void test() throws SQLException {
        DataSource bean = ioc.getBean(DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println(connection);
        connection.close();
//        System.out.println(jdbcTemplate);
    }
}
