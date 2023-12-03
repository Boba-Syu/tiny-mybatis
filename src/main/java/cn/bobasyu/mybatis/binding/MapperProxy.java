package cn.bobasyu.mybatis.binding;

import cn.bobasyu.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映射器代理类，代理dao接口
 *
 * @param <T> 被代理的dao接口类型
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;
    /**
     * 保存有dao接口中被代理方法的信息，如sql语句
     */
    private SqlSession sqlSession;
    /**
     * 被代理的dao接口
     */
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            // 不需要代理
            return method.invoke(this, args);
        }
        return sqlSession.selectOne(method.getName(), args);
    }
}
