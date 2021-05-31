package com.gao.dao;

import com.gao.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据ID查询
    User getUserByID(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();
}
