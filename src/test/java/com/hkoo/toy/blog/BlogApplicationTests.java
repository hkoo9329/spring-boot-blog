package com.hkoo.toy.blog;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {


    @Autowired
    private DataSource ds;

    @Test
    public void testConnection() throws Exception{
        log.info("ds : "+ds);
        Connection con = ds.getConnection();
        log.info("con : "+con);
        con.close();
    }
    @Test
    public void contextLoads() {
    }

}
