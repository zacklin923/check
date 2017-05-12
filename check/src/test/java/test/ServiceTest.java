package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zs.entity.SourceZm;
import com.zs.service.SourceZmSer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class ServiceTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private SourceZmSer sourceZmSer;
	@Resource
	private com.zs.service.SourceTpSer SourceTpSer;
	
	public void getLast() {
		SourceZm zm=sourceZmSer.last("6000014092181");
		System.out.println(zm);
	}
	
	public void testDate() throws ParseException {
		Date date=new SimpleDateFormat("yy/MM/dd HH:mm:ss").parse("1900/01/01 00:00:00");
		System.out.println(date.getTime());
	}
	
	
}
