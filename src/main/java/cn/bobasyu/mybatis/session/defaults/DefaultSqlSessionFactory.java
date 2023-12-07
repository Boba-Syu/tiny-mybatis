package cn.bobasyu.mybatis.session.defaults;

import cn.bobasyu.mybatis.binding.MapperRegistry;
import cn.bobasyu.mybatis.session.Configuration;
import cn.bobasyu.mybatis.session.SqlSession;
import cn.bobasyu.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
