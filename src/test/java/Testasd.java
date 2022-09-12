/*
import com.ssm.book.mapper.BookMapper;
import com.ssm.book.pojo.Book;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utils.SqlSessionUtil;

import java.util.List;

public class Testasd {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList = mapper.getBookList();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
        @Test
        public void test02(){
            List<Book> bookList1 = bookMapper.getBookList();
            for (Book book :bookList1) {
                System.out.println(book);
            }
        }
}
*/
