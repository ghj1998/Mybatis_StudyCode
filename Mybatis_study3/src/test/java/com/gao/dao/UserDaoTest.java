package com.gao.dao;

import com.gao.pojo.User;
import com.gao.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import javax.naming.InsufficientResourcesException;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserByID(3);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void testGetUserByLimit(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex",0);
            map.put("pageSize",3);
            final List<User> users = mapper.getUserByLimit(map);
            for (User user :
                    users) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession session = MybatisUtils.getSqlSession();
        // RowBounds 实现
        RowBounds rowBounds = new RowBounds(1,2);
        //通过JAVA代码层实现分页
        List<User> users = session.selectList("com.gao.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
