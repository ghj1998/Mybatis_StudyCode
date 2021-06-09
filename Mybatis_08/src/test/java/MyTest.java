import com.gao.dao.BlogMapper;
import com.gao.pojo.Blog;
import com.gao.utils.IdUtils;
import com.gao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void getBlogFromID(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            final HashMap map = new HashMap();
            final ArrayList<String> integers = new ArrayList<>();
            integers.add("1");
            integers.add("2");
            map.put("ids",integers);
            System.out.println(mapper.getBlogFromID(map));
        }
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            final HashMap map = new HashMap();
            final ArrayList<String> integers = new ArrayList<>();
            integers.add("1");
            integers.add("2");
            map.put("ids",integers);
            System.out.println(mapper.getBlogFromID(map));
        }
    }
}
