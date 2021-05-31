import com.gao.dao.TeacherMapper;
import com.gao.pojo.Teacher;
import com.gao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void selectTeacher(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            final List<Teacher> teacherList = mapper.getTeacherList();
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        }
    }
}
