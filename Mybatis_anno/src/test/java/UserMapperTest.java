import com.gao.dao.UserMapper;
import com.gao.pojo.User;
import com.gao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        try(final SqlSession  sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User userByID = mapper.getUserByID(2);
            System.out.println(userByID);
        }
    }
}
