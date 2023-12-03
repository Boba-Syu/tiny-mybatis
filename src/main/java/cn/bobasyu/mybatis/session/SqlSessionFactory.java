package cn.bobasyu.mybatis.session;

/**
 * SqlSession工厂
 */
public interface SqlSessionFactory {
    /**
     * 生成SqlSession对象
     *
     * @return
     */
    SqlSession openSqlsession();
}
