package cn.bobasyu.mybatis.session.defaults;

import cn.bobasyu.mybatis.binding.MapperRegistry;
import cn.bobasyu.mybatis.session.SqlSession;
import cn.bobasyu.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSqlsession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
