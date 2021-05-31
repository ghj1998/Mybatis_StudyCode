import com.gao.dao.BlogMapper;
import com.gao.pojo.Blog;
import com.gao.utils.IdUtils;
import com.gao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("gao");
        blog.setCreateTime(new Date());
        blog.setViews(5201);

        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public void testQueryBolgIF(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap();
//            map.put("views",3000);
            final List<Blog> blogs = mapper.queryBolgIF(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void testQueryBolgChoose(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap();
//            map.put("title","Mybatis如此简单");
//            map.put("views",9999);
            final List<Blog> blogs = mapper.queryBolgChoose(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }
}
