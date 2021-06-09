package com.gao.dao;

import com.gao.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    public List<Blog> getBlogFromID(Map map);
}
