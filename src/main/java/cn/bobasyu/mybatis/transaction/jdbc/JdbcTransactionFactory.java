package cn.bobasyu.mybatis.transaction.jdbc;

import cn.bobasyu.mybatis.session.TransactionIsolationLevel;
import cn.bobasyu.mybatis.transaction.Transaction;
import cn.bobasyu.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return null;
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return null;
    }
}
