package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession() {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            //获取核心配置文件的输入流
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取sqlSessionFactory 对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            //获取SqlSession 对象 自动提交
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //返回
        return sqlSession;
    }
}
