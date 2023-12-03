package cn.bobasyu.mybatis.test;

import cn.bobasyu.mybatis.binding.MapperProxyFactory;
import cn.bobasyu.mybatis.test.dao.IUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void mapperProxyTest() {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("cn.bobasyu.mybatis.test.dao.IUserDao.QueryUserName", "模拟mapper.xml中的sql语句执行");

        IUserDao userDao = mapperProxyFactory.newInstance(sqlSession);
        String res = userDao.QueryUserName("user");
        logger.info("测试结果：{}", res);
    }
}
