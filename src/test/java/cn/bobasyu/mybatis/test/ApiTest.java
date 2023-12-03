package cn.bobasyu.mybatis.test;

import cn.bobasyu.mybatis.binding.MapperRegistry;
import cn.bobasyu.mybatis.session.SqlSession;
import cn.bobasyu.mybatis.session.SqlSessionFactory;
import cn.bobasyu.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.bobasyu.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void mapperProxyTest() {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMapper("cn.bobasyu.mybatis.test.dao");

        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSqlsession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        String res = userDao.QueryUserName("user");
        logger.info("测试结果：{}", res);
    }
}
