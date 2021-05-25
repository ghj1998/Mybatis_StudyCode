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

//        //方式一： getMapper
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> userList = userDao.getUserList();

        //方式二：
        List<User> userList = sqlSession.selectList("com.gao.dao.UserDao.getUserList");
        for (User user :
                userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserByID(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            final User userByID = userMapper.getUserByID(1);
            System.out.println(userByID);
        }
    }

    @Test
    public void addUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.addUser(new User(6, "高六", "147258369"));
            if(res>0){
                System.out.println("插入成功"+res);
            }
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(4,"高四四","159357"));
            sqlSession.commit();
        }
    }

    @Test
    public void deleteUser(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(6);
            sqlSession.commit();
        }
    }

    @Test
    public void addUser2(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("userid",6);
            map.put("userName","高六");
            map.put("passWord","123741");

            mapper.addUser2(map);
            sqlSession.commit();
        }
    }

    @Test
    public void getUserLike(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final List<User> userList = mapper.getUserLike("高五%");
            for (User user :
                    userList) {
                System.out.println(user);
            }
        }
    }
}
