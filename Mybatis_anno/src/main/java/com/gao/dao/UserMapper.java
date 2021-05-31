package com.gao.dao;

import com.gao.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();


    // 方法存在多个参数，所有参数必须加@Param("id")注解
    @Select("select * from user where id=#{id}")
    User getUserByID(@Param("id") int id2);
}
