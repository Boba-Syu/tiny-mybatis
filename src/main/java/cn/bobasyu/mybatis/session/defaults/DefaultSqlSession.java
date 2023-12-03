package cn.bobasyu.mybatis.session.defaults;

import cn.bobasyu.mybatis.binding.MapperRegistry;
import cn.bobasyu.mybatis.session.SqlSession;

public class DefaultSqlSession implements SqlSession {
    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("代理方法：" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("代理方法：" + statement + "参数：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
