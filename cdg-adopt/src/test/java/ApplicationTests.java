import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ServletComponentScan
public class ApplicationTests {

    @Test
    public void contextLoads(){
        System.out.println("spring-boot-mybatis");
    }
}
