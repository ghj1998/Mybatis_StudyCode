package com.gao.dao;

import com.gao.pojo.User;
import com.gao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获取SqlSession对象。
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一： getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        //方式二：
//        List<User> userList = sqlSession.selectList("com.gao.dao.UserDao.getUserList");
        for (User user :
                userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

}
