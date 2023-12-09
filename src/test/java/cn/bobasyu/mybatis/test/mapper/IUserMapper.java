package cn.bobasyu.mybatis.test.mapper;

import cn.bobasyu.mybatis.test.entity.User;

public interface IUserMapper {
    User queryUserInfoById(Integer id);
}
