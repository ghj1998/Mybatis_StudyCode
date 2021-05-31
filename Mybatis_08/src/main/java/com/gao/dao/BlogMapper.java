package com.gao.dao;

import com.gao.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);
    List<Blog> queryBolgIF(Map map);

    List<Blog> queryBolgChoose(Map map);
}
