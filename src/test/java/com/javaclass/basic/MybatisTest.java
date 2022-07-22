package com.javaclass.basic;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Test
	public void getTime() {
		try {
			SqlSession session = ssf.openSession();
			String str = session.selectOne("org.javassem.TestMapper.getTime");
			System.out.println("결과: " + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
