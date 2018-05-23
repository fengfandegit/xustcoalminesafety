import com.xust.MySpringBootApplication;
import com.xust.dao.UserMapper;
import com.xust.utils.MD5.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by lenovo on 2018/5/16.
 */
/*@MapperScan("com.xust.dao")*/
@SpringBootTest(classes = MySpringBootApplication.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class InsertTest {
    @Autowired
    UserMapper userMapper;

/*    @Before
    public void init() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) classPathXmlApplicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        classPathXmlApplicationContext.close();
    }*/
    @Test
    public  void main(){
        try {
            userMapper.insertInfo(UUID.randomUUID().toString(),"13319193336",
                    MD5Util.EncoderByMd5("FengFan_19950425/1234"),
                    "封帆","CT06523",0,"testone","1234");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
