package cn.bobasyu.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务接口
 */
public interface Transaction {
    Connection getConnection() throws SQLException;

    /**
     * 事务提交
     *
     * @throws SQLException
     */
    void commit() throws SQLException;

    /**
     * 事务回滚
     *
     * @throws SQLException
     */
    void rollback() throws SQLException;

    /**
     * 关闭事务
     *
     * @throws SQLException
     */
    void close() throws SQLException;
}
