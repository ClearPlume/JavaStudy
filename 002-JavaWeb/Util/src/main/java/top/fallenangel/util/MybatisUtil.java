package top.fallenangel.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSession sqlSession;

    public static InputStream getResource(String resource) {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    public static void initial(InputStream in) {
        initial(in, true);
    }

    public static void initial(InputStream in, boolean autoCommit) {
        if (null == sqlSession) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession(autoCommit);
        }
    }

    public static <T> T getMapper(Class<T> clazz) {
        return sqlSession.getMapper(clazz);
    }
}