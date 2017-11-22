import com.txc.mysql.mybatis.base.SqlSessionFactoryUtil;
import com.txc.mysql.mybatis.domain.User;
import com.txc.mysql.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by tanxiaocan on 2017/11/14.
 */
public class Main {
    public static void main(String[] args){
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUid(10645923,1);
        System.out.println(user);
    }
}
