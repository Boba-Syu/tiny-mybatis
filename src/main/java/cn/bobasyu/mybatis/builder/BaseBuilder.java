package cn.bobasyu.mybatis.builder;

import cn.bobasyu.mybatis.session.Configuration;
import cn.bobasyu.mybatis.type.TypeAliasRegistry;

public abstract class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
