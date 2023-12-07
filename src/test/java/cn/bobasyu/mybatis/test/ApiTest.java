package cn.bobasyu.mybatis.test;

import cn.bobasyu.mybatis.builder.xml.XMLConfigBuilder;
import cn.bobasyu.mybatis.io.Resources;
import cn.bobasyu.mybatis.session.Configuration;
import cn.bobasyu.mybatis.session.SqlSession;
import cn.bobasyu.mybatis.session.SqlSessionFactory;
import cn.bobasyu.mybatis.session.SqlSessionFactoryBuilder;
import cn.bobasyu.mybatis.session.defaults.DefaultSqlSession;
import cn.bobasyu.mybatis.test.entity.User;
import cn.bobasyu.mybatis.test.mapper.IUserMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

public class ApiTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testSqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        // 3. 测试验证
        User user = userMapper.queryUserInfoById(1L);
        logger.info("测试结果：{}", user);
    }

    @Test
    public void testSelectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("cn.bobasyu.mybatis.test.mapper.IUserMapper.queryUserInfoById", req);
        logger.info("测试结果：{}", req);
    }
}
