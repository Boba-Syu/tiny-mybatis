package cn.bobasyu.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 代理工厂，封装代理方法，用于生成代理对象
 */
public class MapperProxyFactory<T> {
    /**
     * 被代理的dao接口
     */
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 生成代理对象
     *
     * @param sqlSession
     * @return
     */
    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}